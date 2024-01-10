import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectCarRental extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JTable resultTable;

    public SelectCarRental() {
        super("Modern Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(new BorderLayout());

        searchField = new JTextField();
        searchButton = new JButton("Search");
        resultTable = new JTable();

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String searchTerm = searchField.getText();
            String query = "SELECT * FROM AvailableCarsView";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchTerm + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // display in table
                DefaultTableModel model = new DefaultTableModel();
                ResultSetMetaData metaData = resultSet.getMetaData();

                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(metaData.getColumnName(i));
                }

                while (resultSet.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    model.addRow(row);
                }
                resultTable.setModel(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set the look and feel to Nimbus for a modern appearance
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }

            SelectCarRental app = new SelectCarRental();
            app.setVisible(true);
        });
    }
}

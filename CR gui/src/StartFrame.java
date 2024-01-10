import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    StartFrame () {
        ImageIcon logo = new ImageIcon("../images/logo.png");
        JLabel title = new JLabel();
        JButton addButton = new JButton("ADD");
        JButton selectButton = new JButton("SELECT");


        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Car Rental");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(203, 202, 205));

        title.setText("Select a Car Rental");
        title.setHorizontalAlignment(JLabel.LEFT);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("MV Boli", Font.BOLD, 35));

        addButton.setBounds(200, 50, 180, 80);
        selectButton.setBounds(200, 180, 180, 80);
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == selectButton){
                    dispose();
                    SelectCarRental selectCR = new SelectCarRental();
                }
            }
        });

        this.add(title);
        this.add(addButton);
        this.add(selectButton);

    }
}

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {
    StartFrame () {
        ImageIcon logo = new ImageIcon("../images/logo.png");
        JLabel title = new JLabel();

        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Car Rental");
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(209, 175, 111));

        title.setText("Car Rental");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setFont(new Font("MV Boli", Font.BOLD, 35));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 175, 111));
        panel.setBounds(0, 0, 1080, 200);
        this.add(panel);
        panel.add(title);
    }
}

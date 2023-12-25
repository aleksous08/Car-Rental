import javax.swing.*;
import java.awt.*;

public class SelectCarRental extends JFrame {
    SelectCarRental(){
        ImageIcon logo = new ImageIcon("../images/logo.png");
        JLabel title = new JLabel();


        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Car Rental");
        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(203, 202, 205));
    }
}

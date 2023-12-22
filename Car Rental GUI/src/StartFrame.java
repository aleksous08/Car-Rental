import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame{
    StartFrame(){
        ImageIcon logo = new ImageIcon("../images/logo.png");
        this.setVisible(true);
        this.setTitle("Car Rental");
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(209, 175, 111));
    }
}

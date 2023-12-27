import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCarRental extends JFrame {
    SelectCarRental(){
        ImageIcon logo = new ImageIcon("../images/logo.png");
        JLabel title = new JLabel();
        JButton backButton = new JButton();

        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Car Rental");
        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(203, 202, 205));

        backButton.setBounds(200, 50, 50, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StartFrame startFrame = new StartFrame();
            }
        });
        this.add(backButton);
    }
}

package kuis2.view;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kuis2.controller.DatabaseController;
import kuis2.model.User;
import kuis2.model.UserManager;

public class LoginView {
    public LoginView(){
        DatabaseController controller = new DatabaseController();
        
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 1));
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("icon.png"));
        } catch (IOException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(img);
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = controller.getUserByEmail(emailField.toString());
                if(user.getEmail() == emailField.toString() && user.getPassword() == passwordField.toString()){
                    UserManager.getInstance().setUser(user);
                }else {
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        frame.add(imgLabel);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(backButton);
        frame.setVisible(true);
    }
    
}

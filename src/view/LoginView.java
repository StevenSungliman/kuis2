package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.DatabaseController;
import java.awt.event.WindowEvent;
import model.User;
import model.UserManager;

public class LoginView {
    public LoginView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(8, 1));
        
        java.net.URL imgUrl = LoginView.class.getResource("icon.png");
        ImageIcon icon = new ImageIcon(imgUrl);
        JLabel imgLabel = new JLabel(icon);
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = DatabaseController.getUserByEmail(emailField.getText());
                if(user.getEmail().equals(emailField.getText()) && user.getPassword().equals(new String(passwordField.getPassword()))){
                    UserManager.getInstance().setUser(user);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    new UserMenuView();
                }else {
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new MainMenuView();
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

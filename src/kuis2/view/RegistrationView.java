package kuis2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import kuis2.controller.DatabaseController;
import kuis2.model.CategoryUser;
import kuis2.model.User;

public class RegistrationView {
    public RegistrationView(){
        DatabaseController controller = new DatabaseController();
        
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 1));
        
        JLabel nameLabel = new JLabel("Nama");
        JTextField nameField = new JTextField();
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        
        ArrayList<CategoryUser> arrCategory = controller.getCategory();
        JComboBox categoryCombo = new JComboBox(arrCategory.toArray());
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setName(nameField.toString());
                user.setEmail(emailField.toString());
                user.setPassword(passwordField.toString());
                user.setIdCategory(1);
                controller.addUser(user);
            }
        });
        
        JButton backButton = new JButton("Back");
        
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(categoryCombo);
        frame.add(registerButton);
        frame.add(backButton);
        frame.setVisible(true);
    }
}

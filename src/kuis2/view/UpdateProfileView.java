package kuis2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import kuis2.controller.DatabaseController;
import kuis2.model.CategoryUser;
import kuis2.model.User;

public class UpdateProfileView {
    public UpdateProfileView(){
        DatabaseController controller = new DatabaseController();
        
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 1));
        
        User user = controller.getUserByID(0);
        
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(user.getName());
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(user.getEmail());
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(user.getPassword());
        
        CategoryUser[] arrCategory = new CategoryUser[1];
        JComboBox categoryCombo = new JComboBox(arrCategory);
        
        JButton updateButton = new JButton("Simpan");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setName(nameField.toString());
                user.setEmail(emailField.toString());
                user.setPassword(passwordField.toString());
                user.setIdCategory(1);
                controller.updateUser(user);
            }
        });
        
        JButton deleteButton = new JButton("Hapus Data");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setName(nameField.toString());
                user.setEmail(emailField.toString());
                user.setPassword(passwordField.toString());
                user.setIdCategory(1);
                controller.deleteUser(user);
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

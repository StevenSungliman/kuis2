package view;

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
import controller.DatabaseController;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.CategoryUser;
import model.User;

public class RegistrationView {
    public RegistrationView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(20, 1));
        
        JLabel nameLabel = new JLabel("Nama");
        JTextField nameField = new JTextField();
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        
        ArrayList<CategoryUser> arrCategory = DatabaseController.getCategory();
        ArrayList<String> arrCategoryName = new ArrayList<>();
        for(int i = 0; i < arrCategory.size(); i++){
            arrCategoryName.add(arrCategory.get(i).getName());
        }
        JComboBox categoryCombo = new JComboBox(arrCategoryName.toArray());
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setName(nameField.getText());
                user.setEmail(emailField.getText());
                user.setPassword(new String(passwordField.getPassword()));
                user.setIdCategory(DatabaseController.getCategoryByName((String)(categoryCombo.getSelectedItem())).getId());
                if(DatabaseController.addUser(user)){
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                }else{
                    JOptionPane.showMessageDialog(null, "Registrasi Gagal");
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

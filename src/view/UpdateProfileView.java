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
import model.CategoryUser;
import model.User;
import model.UserManager;

public class UpdateProfileView {
    public UpdateProfileView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(20, 1));
        
        User user = UserManager.getInstance().getUser();
        
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(user.getName());
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(user.getEmail());
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(user.getPassword());
        
        ArrayList<CategoryUser> arrCategory = DatabaseController.getCategory();
        ArrayList<String> arrCategoryName = new ArrayList<>();
        for(int i = 0; i < arrCategory.size(); i++){
            arrCategoryName.add(arrCategory.get(i).getName());
        }
        JComboBox categoryCombo = new JComboBox(arrCategoryName.toArray());
        
        JButton updateButton = new JButton("Simpan");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setId(user.getId());
                user.setName(nameField.getText());
                user.setEmail(emailField.getText());
                user.setPassword(new String(passwordField.getPassword()));
                user.setIdCategory(DatabaseController.getCategoryByName((String)(categoryCombo.getSelectedItem())).getId());
                DatabaseController.updateUser(user);
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
                DatabaseController.deleteUser(user.getId());
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
        frame.add(updateButton);
        frame.add(backButton);
        frame.setVisible(true);
    }
}

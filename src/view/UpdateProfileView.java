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
import model.UserManager;

public class UpdateProfileView {
    public UpdateProfileView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(20, 1));
        
        User usersingleton = UserManager.getInstance().getUser();
        
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(usersingleton.getName());
        
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(usersingleton.getEmail());
        
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(usersingleton.getPassword());
        
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
                user.setId(usersingleton.getId());
                user.setName(nameField.getText());
                user.setEmail(emailField.getText());
                user.setPassword(new String(passwordField.getPassword()));
                user.setIdCategory(DatabaseController.getCategoryByName((String)(categoryCombo.getSelectedItem())).getId());
                if(DatabaseController.updateUser(user)){
                    JOptionPane.showMessageDialog(null, "Update Berhasil");
                }else{
                    JOptionPane.showMessageDialog(null, "Update Gagal");
                }
            }
        });
        
        JButton deleteButton = new JButton("Hapus Data");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setId(usersingleton.getId());
                user.setName(nameField.getText());
                user.setEmail(emailField.getText());
                user.setPassword(new String(passwordField.getPassword()));
                user.setIdCategory(DatabaseController.getCategoryByName((String)(categoryCombo.getSelectedItem())).getId());
                if(DatabaseController.deleteUser(user.getId())){
                    JOptionPane.showMessageDialog(null, "Hapus Berhasil");
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    new MainMenuView();
                }else{
                    JOptionPane.showMessageDialog(null, "Hapus Gagal");
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
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(backButton);
        frame.setVisible(true);
    }
}

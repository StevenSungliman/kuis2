package kuis2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import kuis2.controller.DatabaseController;
import kuis2.model.CategoryUser;
import kuis2.model.User;

public class LihatView {
    public LihatView(){
        DatabaseController controller = new DatabaseController();
        
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 1));
        
        String[] columnNames = {"Id", "Name", "Email", "Password", "Category"};
        JTable tabel = null;
        
        CategoryUser[] arrCategory = new CategoryUser[1];
        JComboBox categoryCombo = new JComboBox(arrCategory);
        
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> users = controller.getUser(1);
                TableModel model = new UserTableModel(users);
            }
        });
        
        frame.add(categoryCombo);
        frame.add(searchButton);
        frame.add(tabel);
        frame.setVisible(true);
    }
}

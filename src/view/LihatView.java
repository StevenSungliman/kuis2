package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import controller.DatabaseController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import model.CategoryUser;
import model.User;

public class LihatView {
    public LihatView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        ArrayList<CategoryUser> arrCategory = DatabaseController.getCategory();
        ArrayList<String> arrCategoryName = new ArrayList<>();
        for(int i = 0; i < arrCategory.size(); i++){
            arrCategoryName.add(arrCategory.get(i).getName());
        }
        JComboBox categoryCombo = new JComboBox(arrCategoryName.toArray());
        
        JButton searchButton = new JButton("Search");
        c.gridx = 0;
        c.gridy = 0;
        frame.add(categoryCombo, c);
        c.gridx = 0;
        c.gridy = 1;
        frame.add(searchButton, c);
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = DatabaseController.getCategoryByName((String)(categoryCombo.getSelectedItem())).getId();
                ArrayList<User> arrUser = DatabaseController.getUser(choice);
                String[][] tableData = new String[arrUser.size()][5];
                for(int i = 0; i < arrUser.size(); i++){
                    tableData[i][0] = String.valueOf(arrUser.get(i).getId());
                    tableData[i][1] = arrUser.get(i).getName();
                    tableData[i][2] = arrUser.get(i).getEmail();
                    tableData[i][3] = arrUser.get(i).getPassword();
                    tableData[i][4] = String.valueOf(arrUser.get(i).getIdCategory());
                }
                
                String[] columnNames = {"Id", "Name", "Email", "Password", "Category"};
                JTable tabel = new JTable(tableData, columnNames);
                tabel.setBounds(1000, 100, 300, 400);
                JScrollPane sp = new JScrollPane(tabel);
                c.gridx = 0;
                c.gridy = 2;
                c.ipadx = 500;
                c.ipady = 250;
                c.gridheight = 18;
                frame.add(sp, c);
                frame.setVisible(true);
            }
        });
        
        frame.setVisible(true);
    }
}

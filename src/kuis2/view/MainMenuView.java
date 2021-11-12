package kuis2.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenuView {
    public MainMenuView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout());
        
        JButton login = new JButton("Login Pengguna");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
                frame.setVisible(false);
            }
        });
        
        JButton register = new JButton("Registrasi Pengguna Baru");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationView();
                frame.setVisible(false);
            }
        });
        
        JButton lihat = new JButton("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatView();
                frame.setVisible(false);
            }
        });
        
        frame.add(login);
        frame.add(register);
        frame.add(lihat);
        frame.setVisible(true);
    }
}

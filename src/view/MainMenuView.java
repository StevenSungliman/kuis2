package view;

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
        frame.setLayout(new GridLayout(20, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton login = new JButton("Login Pengguna");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView();
                frame.setVisible(false);
            }
        });
        
        JButton register = new JButton("Registrasi Pengguna Baru");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationView();
                frame.setVisible(false);
            }
        });
        
        JButton lihat = new JButton("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
        lihat.addActionListener(new ActionListener() {
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

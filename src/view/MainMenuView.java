package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenuView {
    public MainMenuView(){
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(20, 1));
        
        JButton login = new JButton("Login Pengguna");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new LoginView();
            }
        });
        
        JButton register = new JButton("Registrasi Pengguna Baru");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new RegistrationView();
            }
        });
        
        JButton lihat = new JButton("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
        lihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new LihatView();
            }
        });
        
        frame.add(login);
        frame.add(register);
        frame.add(lihat);
        frame.setVisible(true);
    }
}

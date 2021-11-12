package kuis2.main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kuis2.controller.DatabaseController;
import kuis2.view.MainMenuView;

public class Main {
    public Main(){
        new MainMenuView();
    }
    public static void main(String[] args) {
        new Main();
    }
}

package Frames;

import javax.swing.*;
import java.awt.*;

public class Menu{

    private JFrame frame;

    public Menu(){
        frame = new JFrame();
    }

    public void init(){
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
    }
}

package Frames;

import javax.swing.*;
import java.awt.*;

public class GameFrame{

    private JFrame frame;

    public GameFrame(){
        frame = new JFrame();
        frame.setTitle("KittyJump");
    }

    public void init(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

package Frames;

import javax.swing.*;
import java.awt.*;

public class GameFrame{

    private JFrame frame;

    public GameFrame(){
        frame = new JFrame();
    }

    public void init(){
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}

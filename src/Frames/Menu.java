package Frames;

import javax.swing.*;
import java.awt.*;

public class Menu{

    private JFrame frame;

    public Menu(){
        frame = new JFrame();
    }

    public void init(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBackground(Color.BLACK);
        JButton button = new JButton("Start");
        JButton button2 = new JButton("Exit");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension btnSize = new Dimension(200, 100);
        button.setPreferredSize(btnSize);
        button.setMaximumSize(btnSize);
        button.setMinimumSize(btnSize);
        button2.setPreferredSize(btnSize);
        button2.setMaximumSize(btnSize);
        button2.setMinimumSize(btnSize);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button2.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(Box.createVerticalGlue());
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(button2);
        panel.add(Box.createVerticalGlue());
        button.addActionListener(e -> {
            frame.dispose();
            new GameFrame().init();
        });
        button2.addActionListener(e -> System.exit(0));
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

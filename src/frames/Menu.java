package frames;

import game.MenuPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the main menu frame of the game.
 */
public class Menu extends JFrame{

    private Image background = new ImageIcon("res/background.png").getImage();

    public Menu(){
    }

    /**
     * Initializes the menu frame with title, size and Play and Exit buttons.
     */
    public void init(){
        this.setTitle("KittyJump - Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setPreferredSize(new Dimension(600, this.getHeight()));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("KittyJump");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 64));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton startButton = new JButton("Play");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> {
            GameFrame game = new GameFrame();
            this.dispose();
            game.init();
        });
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> this.dispose());
        menuPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        menuPanel.add(titleLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        menuPanel.add(startButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        menuPanel.add(exitButton);

        this.add(menuPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

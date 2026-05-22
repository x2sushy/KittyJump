package frames;

import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {

    private JFrame frame;
    private int finalScore;

    public GameOverFrame(int score){
        frame = new JFrame();
        this.finalScore = score;
    }

    public void init(){
        this.setTitle("Game Over");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        JLabel scoreLabel = new JLabel("Game Over! Score: " + finalScore);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 48));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton menuButton = new JButton("Menu");
        JButton playAgainButton = new JButton("Play Again");
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> this.dispose());
        playAgainButton.setFont(new Font("Arial", Font.BOLD, 24));
        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame();
            this.dispose();
            gameFrame.init();
        });
        menuButton.setFont(new Font("Arial", Font.BOLD, 24));
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.addActionListener(e -> {
            Menu menu = new Menu();
            this.dispose();
            menu.init();
        });
        panel.add(scoreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(playAgainButton);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(menuButton);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(exitButton);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

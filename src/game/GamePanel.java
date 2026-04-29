package game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Player player;
    private Timer gameLoop;

    //todo add platforms
    public GamePanel() {
        this.setBackground(Color.CYAN);
        this.player = new Player();
        gameLoop = new Timer(16, e -> {
            player.update();
            repaint();
        });
        gameLoop.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}

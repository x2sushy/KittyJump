package game;

import controller.GameController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Player player;
    private Timer gameLoop;

    //todo add platforms
    public GamePanel() {
        this.setBackground(Color.CYAN);
        setOpaque(false);
        setFocusable(true);
        this.player = new Player();
        GameController controller = new GameController(player);
        this.addKeyListener(controller);
        gameLoop = new Timer(16, e -> {
            player.update(16);
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

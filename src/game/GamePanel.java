package game;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private Player player;
    private Timer gameLoop;
    private ArrayList<Platform> platforms;
    private boolean initialized = false;

    public GamePanel() {
        this.setBackground(Color.CYAN);
        setFocusable(true);
        this.player = new Player();
        this.platforms = new ArrayList<>();
        GameController controller = new GameController(player);
        this.addKeyListener(controller);
        gameLoop = new Timer(16, e -> {
            if (!initialized && getWidth() > 0) {
                initializeGame(getWidth(), getHeight());
                initialized = true;
            }
            if (initialized) {
                player.update(getWidth(), getHeight());
                checkCollisions();
            }
            repaint();
        });
        gameLoop.start();
    }

    private void initializeGame(int width, int height) {
        player.setPosition(width / 2 - 20, height / 2 - 100);
        platforms.add(new Platform(width / 2 - 40, height - 150));
        platforms.add(new Platform(width / 2 - 150, height - 300));
        platforms.add(new Platform(width / 2 + 100, height - 450));
        platforms.add(new Platform(width / 2 - 50,  height - 600));
        platforms.add(new Platform(width / 2 + 150, height - 750));
    }

    private void checkCollisions() {
        if (player.getJumpSpeed() > 0) {
            Rectangle playerBounds = player.getBounds();
            for (Platform p : platforms) {
                if (playerBounds.intersects(p.getBounds())) {
                    player.jump();
                    break;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Platform p : platforms) {
            p.draw(g);
        }
        player.draw(g);
    }
}

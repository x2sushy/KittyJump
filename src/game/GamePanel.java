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
    public static final int width = 600;

    public GamePanel() {
        this.setBackground(Color.CYAN);
        setFocusable(true);
        this.player = new Player();
        this.platforms = new ArrayList<>();
        GameController controller = new GameController(player);
        this.addKeyListener(controller);
        gameLoop = new Timer(16, e -> {
            if (!initialized && width > 0) {
                initializeGame(getHeight());
                initialized = true;
            }
            if (initialized) {
                player.update(width, getHeight());
                checkCollisions();
                update();
            }
            repaint();
        });
        gameLoop.start();
    }

    private void initializeGame(int height) {
        player.setPosition(width / 2 - 20, height / 2 - 100);
        platforms.add(new Platform(width / 2 - 40, height - 1000));
        platforms.add(new Platform(width / 2 - 150, height - 800));
        platforms.add(new Platform(width / 2 + 100, height - 200));
        platforms.add(new Platform(width / 2 - 50,  height - 400));
        platforms.add(new Platform(width / 2 + 150, height - 600));
        platforms.add(new Platform(width / 2 + 100, height - 1200));
        platforms.add(new Platform(width / 2 - 150, height - 1400));
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

    private void update(){
        int cameraLine = (int) (getHeight() * 0.4);
        if (player.getY() < cameraLine) {
            int shift = (int) (cameraLine - player.getY());
            player.setY(cameraLine);
            for (Platform p : platforms) {
                p.setY(p.getY() + shift);
            }
        }
        int highestY = Integer.MAX_VALUE;
        for (Platform p : platforms) {
            if (p.getY() < highestY) {
                highestY = p.getY();
            }
        }
        for (int i = platforms.size() - 1; i >= 0; i--) {
            Platform p = platforms.get(i);
            if (p.getY() > getHeight()) {
                platforms.remove(i);
                int newX = (int) (Math.random() * (width - 80));
                int gap = 125 + (int)(Math.random() * 100);
                int newY = highestY - gap;
                platforms.add(new Platform(newX, newY));
                highestY = newY;
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

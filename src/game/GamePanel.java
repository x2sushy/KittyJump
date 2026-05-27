package game;

import controller.GameController;
import frames.GameOverFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private Player player;
    private Timer timer;
    private ArrayList<Platform> platforms;
    private boolean initialized = false;
    private final int width = 600;
    private int score = 0;
    private Image background = new ImageIcon("res/background.png").getImage();

    public GamePanel(JFrame parent) {
        this.setBackground(Color.CYAN);
        setFocusable(true);
        this.player = new Player();
        this.platforms = new ArrayList<>();
        GameController controller = new GameController(player);
        this.addKeyListener(controller);
        timer = new Timer(16, e -> {
            if (!initialized && width > 0) {
                initializeGame(getHeight());
                initialized = true;
            }
            if (initialized) {
                player.update(width);
                for (Platform p : platforms) {
                    p.update(width);
                }
                checkCollisions();
                update();
                if (player.getY()>getHeight()){
                    timer.stop();
                    parent.dispose();
                    new GameOverFrame(score).init();
                }
            }
            repaint();
        });
        timer.start();
    }

    private void initializeGame(int height) {
        player.setPosition(width / 2 - 20, height / 2 - 100);
        platforms.add(new Platform(width / 2 - 40, height - 1000));
        platforms.add(new Platform(width / 2 - 150, height - 800));
        platforms.add(new Platform(width / 2 + 100, height));
        platforms.add(new Platform(width / 2 - 50,  height - 400));
        platforms.add(new Platform(width / 2 + 150, height - 600));
        platforms.add(new Platform(width / 2 + 100, height - 1200));
        platforms.add(new Platform(width / 2 - 150, height - 1400));
    }

    private void checkCollisions() {
        if (player.getJumpSpeed() > 0) {
            Rectangle playerBounds = player.getBounds();
            for (Platform p : platforms) {
                if (p.getPowerUp() != null && p.getPowerUp().getType().equals("SPRING") && playerBounds.intersects(p.getPowerUp().getBounds())) {
                    player.tripleJump();
                    break;
                }else if (playerBounds.intersects(p.getBounds())) {
                    player.jump();
                    if (p.isFragile()) {
                        platforms.remove(p);
                        platforms.add(new Platform(width / 2 - 40, getHeight() + 20));
                    }
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
            score += shift/10;
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
                Platform newPlatform = new Platform(newX, newY);
                int chance = (int)(Math.random() * 100);
                if (chance < 10) {
                    newPlatform.setFragile(true);
                } else if (chance < 25) {
                    newPlatform.setMoving(true);
                } else if (chance < 30) {
                    PowerUp spring = new PowerUp(newX + 80 / 2 - 10, newY - 10, "SPRING");
                    newPlatform.setPowerUp(spring);
                }
                platforms.add(newPlatform);
                highestY = newY;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            int bgHeight = background.getHeight(null);
            if (bgHeight > 0) {
                for (int y = 0; y < getHeight(); y += bgHeight) {
                    g.drawImage(background, 0, y, width, bgHeight, null);
                }
            }
        }
        for (Platform p : platforms) {
            p.draw(g);
        }
        player.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Score: " + score, 20, 40);
    }
}

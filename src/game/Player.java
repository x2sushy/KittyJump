package game;

import java.awt.*;

public class Player {

    private int x = 400;
    private double y = 300;
    private double velocity = 0;
    private double gravity = 0.5;

    public void update() {
        velocity += gravity;
        y += velocity;
        if (y > 600) {
            y = 600;
            velocity = -12;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, (int) y, 40, 40);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, (int)y, 40, 40);
    }

    public double getVelocityY() {
        return velocity;
    }

    public void jump() {
        velocity = -12;
    }
}

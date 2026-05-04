package game;

import java.awt.*;

public class Player {

    private int x = 400;
    private double y = 300;
    private double jumpSpeed = 0;
    private final double speed = 10;
    private double gravity = 0.5;
    private boolean isGoingLeft;
    private boolean isGoingRight;

    public void update(double deltaT) {
        jumpSpeed += gravity;
        y += jumpSpeed;
        if (y > 600) {
            y = 600;
            jumpSpeed = -12;
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

    public void addX (int deltaX){
        this.x += deltaX;
    }

    public void setGoingRight(boolean goingRight) {
        isGoingRight = goingRight;
    }

    public void setGoingLeft(boolean goingLeft) {
        isGoingLeft = goingLeft;
    }

    public boolean isGoingLeft() {
        return isGoingLeft;
    }

    public boolean isGoingRight() {
        return isGoingRight;
    }
}

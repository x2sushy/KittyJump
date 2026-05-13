package game;

import java.awt.*;

public class Player {

    private int x;
    private double y;
    private double jumpSpeed = 0;
    private final double speed = 10;
    private final double gravity = 0.5;
    private boolean isGoingLeft;
    private boolean isGoingRight;

    public void update(int screenWidth, int screenHeight) {
        jumpSpeed += gravity;
        y += jumpSpeed;
        if (y > screenHeight) {
            y = screenHeight - 40;
            jumpSpeed = -20;
        }
        if (isGoingRight) {
            x += (int) speed;
        }
        if (isGoingLeft) {
            x -= (int) speed;
        }
        if (x > screenWidth) {
            x = -40;
        } else if (x < -40) {
            x = screenWidth;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, (int) y, 40, 40);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, (int)y, 40, 40);
    }

    public double getJumpSpeed() {
        return jumpSpeed;
    }

    public void jump() {
        jumpSpeed = -20;
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

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

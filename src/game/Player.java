package game;

import javax.swing.*;
import java.awt.*;

public class Player {

    private int x;
    private double y;
    private double jumpSpeed = 0;
    private final double speed = 10;
    private final double gravity = 0.5;
    private boolean isGoingLeft;
    private boolean isGoingRight;
    private Image kitty;

    /**
     * Constructs a new Player and loads the image.
     */
    public Player() {
        kitty = new ImageIcon("res/kitty.png").getImage();
    }

    /**
     * Updates the player's position based on jump speed, gravity, and horizontal movement.
     * @param screenWidth the width of the game screen for passing from one edge to another
     */
    public void update(int screenWidth) {
        jumpSpeed += gravity;
        y += jumpSpeed;
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

    /**
     * Draws the player image at the current position.
     * @param g the Graphics object
     */
    public void draw(Graphics g) {
        g.drawImage(kitty, x, (int)y, null);
    }

    /**
     * AI advised me to use rectangle to check for collisions.
     * Returns the rectangle of the player for collision detection.
     * @return a Rectangle representing the player's bounds
     */
    public Rectangle getBounds() {
        return new Rectangle(x, (int)y, 40, 40);
    }

    public double getJumpSpeed() {
        return jumpSpeed;
    }

    /**
     * Causes the player to jump by setting a negative vertical velocity.
     */
    public void jump() {
        jumpSpeed = -15;
    }

    /**
     * Causes the player to perform a higher jump (supposedly 3x higher).
     */
    public void tripleJump(){
        jumpSpeed = -15*1.7;
    }

    public void setGoingRight(boolean goingRight) {
        isGoingRight = goingRight;
    }

    public void setGoingLeft(boolean goingLeft) {
        isGoingLeft = goingLeft;
    }

    /**
     * Sets the player's position.
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

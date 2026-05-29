package game;

import javax.swing.*;
import java.awt.*;

public class Platform {

    private int x;
    private int y;
    private int width = 80;
    private int height = 20;
    private Image platform = new ImageIcon("res/platform.png").getImage();
    private Image movingPlatform = new ImageIcon("res/movingplatform.png").getImage();
    private Image brokenPlatform = new ImageIcon("res/brokenplatform.png").getImage();
    private PowerUp powerUp = null;
    private boolean isFragile = false;
    private boolean isMoving = false;
    private int speed = 3;

    /**
     * Constructs a new Platform at the specified coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Platform(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Draws the platform and its power-up if it has one.
     * @param g the Graphics object
     */
    public void draw(Graphics g) {
        if (isFragile) {
            g.drawImage(brokenPlatform, x, y, width, height, null);
        } else if (isMoving) {
            g.drawImage(movingPlatform, x, y, width, height, null);
        } else {
            g.drawImage(platform, x, y, width, height, null);
        }
        if (powerUp != null) {
            powerUp.draw(g);
        }
    }

    /**
     * Updates the platform's position if it is a moving platform.
     * @param screenWidth the width of the game screen
     */
    public void update(int screenWidth) {
        if (isMoving) {
            x += speed;
            if (x < 0) {
                x = 0;
                speed = -speed;
            }else if (x + width > screenWidth) {
                x = screenWidth - width;
                speed = -speed;
            }
        }
    }

    /**
     * AI advised me to use rectangle to check for collisions.
     * Returns the rectangle of the platform for collision detection.
     * @return a Rectangle representing the platform's bounds
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the platform and updates its power-up's position if it has one.
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        int shift = y - this.y;
        this.y = y;
        if (powerUp != null) {
            powerUp.setY(powerUp.getY() + shift);
        }
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}

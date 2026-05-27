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

    public Platform(int x, int y){
        this.x = x;
        this.y = y;
    }

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

    // secret for rectangle collision from AI
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }

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

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}

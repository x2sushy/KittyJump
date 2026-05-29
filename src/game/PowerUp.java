package game;

import javax.swing.*;
import java.awt.*;

public class PowerUp {

    private int x;
    private int y;
    private int width = 20;
    private int height = 10;
    private String type;
    private Image spring = new ImageIcon("res/spring.png").getImage();

    /**
     * Constructs a new PowerUp at the specified position.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param type the type of the power-up
     */
    public PowerUp(int x, int y, String type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * AI advised me to use rectangle to check for collisions.
     * Returns the bounding rectangle of the power-up for collision detection.
     * @return a Rectangle representing the power-up's bounds
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    /**
     * Draws the power-up image based on its type.
     * @param g the Graphics object
     */
    public void draw(Graphics g){
        if (type.equals("SPRING")) {
            g.drawImage(spring, x, y, width, height, null);
        }
    }

    public String getType() {
        return type;
    }
}

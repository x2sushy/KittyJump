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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g){
        if (type.equals("SPRING")) {
            g.drawImage(spring, x, y, width, height, null);
        }
    }

    public String getType() {
        return type;
    }
}

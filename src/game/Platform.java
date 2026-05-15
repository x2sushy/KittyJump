package game;

import javax.swing.*;
import java.awt.*;

public class Platform {

    private int x;
    private int y;
    private int width = 80;
    private int height = 20;
    private Image image = new ImageIcon("res/New Piskel-1.png.png").getImage();

    public Platform(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.drawImage(image,x,y,width,height,null);
//        g.setColor(Color.ORANGE);
//        g.fillRect(x, y, width, height);
    }

    // secret for rectangle collision
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

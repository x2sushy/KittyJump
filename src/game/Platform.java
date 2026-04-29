package game;

import java.awt.*;

public class Platform {

    private int x;
    private int y;
    private static int width = 80;
    private static int height = 20;

    public Platform(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
    }

    // secret for rectangle collision
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

package game;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JPanel used in the Menu frame to draw the background image.
 */
public class MenuPanel extends JPanel {

    private Image bgImage = new ImageIcon("res/background.png").getImage();

    /**
     * Paints the background image so it fits any size.
     * @param g the Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            int bgHeight = bgImage.getHeight(null);
            if (bgHeight > 0) {
                for (int y = 0; y < getHeight(); y += bgHeight) {
                    g.drawImage(bgImage, 0, y, getWidth(), bgHeight, null);
                }
            }
        }
    }
}

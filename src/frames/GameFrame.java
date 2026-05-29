package frames;
import game.GamePanel;
import javax.swing.*;
import java.awt.*;

/**
 * The frame that holds the actual game panel where the game is played.
 */
public class GameFrame extends JFrame{

    /**
     * Constructs a new GameFrame and sets the title.
     */
    public GameFrame(){
        this.setTitle("KittyJump");
    }

    /**
     * Initializes the game frame, sets up the layout, and adds the GamePanel.
     */
    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        GamePanel panel = new GamePanel(this);
        panel.setPreferredSize(new Dimension(600, 800));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        this.add(panel, gbc);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

package frames;
import game.GamePanel;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    public GameFrame(){
        this.setTitle("KittyJump");
    }

    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(600, 800));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        this.add(panel, gbc);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

package frames;
import game.GamePanel;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    private JFrame frame;

    public GameFrame(){
        this.setTitle("KittyJump");
    }

    public void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        GamePanel panel = new GamePanel();
        this.add(panel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

package controller;

import game.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles key events for controlling the player's movement.
 */
public class GameController implements KeyListener {
    private final Player p;

    /**
     * Constructs a new GameController for the given player.
     * @param p the player to control
     */
    public GameController(Player p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Responds to key presses to move the player left or right.
     * @param e the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> {
                p.setGoingRight(true);
            }
            case KeyEvent.VK_LEFT -> {
                p.setGoingLeft(true);
            }
        }
    }

    /**
     * Responds to key releases to stop the player's movement.
     * @param e the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> {
                p.setGoingRight(false);
            }
            case KeyEvent.VK_LEFT -> {
                p.setGoingLeft(false);
            }
        }
    }
}

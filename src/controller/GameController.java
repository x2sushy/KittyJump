package controller;

import game.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private final Player p;

    public GameController(Player p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

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

package com.seleon.tetris.controller;

import com.seleon.tetris.view.game.GameWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Sergey Mikhluk.
 */
public class KeyListener extends KeyAdapter {
    private GameWindow gameWindow;
    private Controller controller;

    public KeyListener(GameWindow gameWindow, Controller controller) {
        this.gameWindow = gameWindow;
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.getCommand(String.valueOf(e.getKeyCode())).execute();
        windowRepaint();
    }

    private void windowRepaint() {
        gameWindow.repaint();
    }
}
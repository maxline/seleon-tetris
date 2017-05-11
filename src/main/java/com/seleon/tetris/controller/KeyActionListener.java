package com.seleon.tetris.controller;

import com.seleon.tetris.view.game.GameWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Sergey Mikhluk.
 */
public class KeyActionListener extends KeyAdapter {
    private GameWindow gameWindow = GameWindow.getInstance(); //todo переписать через dependency injection в конструкторе

    @Override
    public void keyPressed(KeyEvent e) {
        ControllerHelper.getInstance().getCommand(e.getKeyCode()).execute();
        windowRepaint();
    }

    private void windowRepaint() {
        gameWindow.repaint();
    }
}
package com.seleon.tetris.controller;

import com.seleon.tetris.model.TetrisBoard;
import com.seleon.tetris.view.TetrisWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Sergey Mikhluk.
 */
public class KeyActionListener extends KeyAdapter {

    private TetrisWindow tetrisWindow;

    public KeyActionListener(TetrisWindow tetrisWindow) {
        this.tetrisWindow = tetrisWindow;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            TetrisBoard.getInstance().decrementX(1);
        }
        tetrisWindow.repaint();
    }
}

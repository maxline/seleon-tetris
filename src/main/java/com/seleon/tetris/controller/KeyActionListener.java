package com.seleon.tetris.controller;

import com.seleon.tetris.model.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Sergey Mikhluk.
 */
public class KeyActionListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        Game game = Game.getInstance();

        switch (e.getKeyCode()) {
            case (KeyEvent.VK_LEFT):
                game.moveLeft();
                break;
            case (KeyEvent.VK_RIGHT):
                game.moveRight();
                break;
            case (KeyEvent.VK_DOWN):
                game.moveDown();
                break;
            case (KeyEvent.VK_SPACE):
                game.go();
                break;
        }
    }
}

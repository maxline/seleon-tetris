package com.seleon.tetris.controller;

import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class ControllerInitializer {

    public ControllerInitializer(GameWindow gameWindow) {
        gameWindow.getBoardPanel().addBoardMouseListener(new MouseActionListener(gameWindow));
        gameWindow.getBoardPanel().addBoardKeyListener(new KeyController(gameWindow));
    }

}

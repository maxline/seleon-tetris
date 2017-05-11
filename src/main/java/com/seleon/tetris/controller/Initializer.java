package com.seleon.tetris.controller;

import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Initializer {

    public Initializer() {
        initControllers();
    }

    private void initControllers() {
        GameWindow.getInstance().getBoardPanel().addBoardMouseListener(new MouseActionListener(GameWindow.getInstance()));
        GameWindow.getInstance().getBoardPanel().addBoardKeyListener(new KeyController(GameWindow.getInstance()));
    }
}

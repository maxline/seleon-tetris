package com.seleon.tetris.controller;

import com.seleon.tetris.view.TetrisWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Controller {

    private TetrisWindow tetrisWindow;

    public Controller(TetrisWindow tetrisWindow) {
        this.tetrisWindow = tetrisWindow;
        initControllers();
    }

    private void initControllers() {
        tetrisWindow.addBoardMouseListener(new MouseActionListener(tetrisWindow));
        tetrisWindow.addBoardKeyListener(new KeyActionListener(tetrisWindow));
    }
}

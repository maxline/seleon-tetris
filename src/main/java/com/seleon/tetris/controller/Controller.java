package com.seleon.tetris.controller;

import com.seleon.tetris.view.game.BoardPanel;

/**
 * @author Sergey Mikhluk.
 */
public class Controller {

    public Controller() {
        initControllers();
    }

    private void initControllers() {
        BoardPanel.getInstance().addBoardMouseListener(new MouseActionListener());
        BoardPanel.getInstance().addBoardKeyListener(new KeyActionListener());
    }
}

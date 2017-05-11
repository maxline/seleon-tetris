package com.seleon.tetris.controller;

import com.seleon.tetris.view.game.BoardPanel;
import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Initializer {

    public Initializer() {
        initControllers();
    }

    private void initControllers() {
        BoardPanel.getInstance().addBoardMouseListener(new MouseActionListener(GameWindow.getInstance()));
        BoardPanel.getInstance().addBoardKeyListener(new KeyController(GameWindow.getInstance()));
    }
}

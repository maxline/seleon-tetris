package com.seleon.tetris.controller;

import com.seleon.tetris.view.MinePanel;

/**
 * @author Sergey Mikhluk.
 */
public class Controller {

    public Controller() {
        initControllers();
    }

    private void initControllers() {
        MinePanel.getInstance().addBoardMouseListener(new MouseActionListener());
        MinePanel.getInstance().addBoardKeyListener(new KeyActionListener());
    }
}

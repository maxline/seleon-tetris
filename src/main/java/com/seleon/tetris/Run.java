package com.seleon.tetris;

import com.seleon.tetris.controller.Controller;
import com.seleon.tetris.controller.Game;
import com.seleon.tetris.view.TetrisWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Run {
    public static void main(String[] args) {
        TetrisWindow.getInstance();
        new Controller();
        new Game().go();
    }
}

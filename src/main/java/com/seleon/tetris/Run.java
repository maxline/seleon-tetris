package com.seleon.tetris;

import com.seleon.tetris.controller.Controller;
import com.seleon.tetris.model.Game;
import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Run {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        new Controller(gameWindow);
        Game.getInstance().setGameWindow(gameWindow);
        Game.getInstance().go();
    }
}

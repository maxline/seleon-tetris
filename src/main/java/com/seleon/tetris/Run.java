package com.seleon.tetris;

import com.seleon.tetris.controller.ControllerInitializer;
import com.seleon.tetris.model.Game;
import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Run {
    public static void main(String[] args) {
        new ControllerInitializer(new GameWindow());
        Game.getInstance().go();
    }
}

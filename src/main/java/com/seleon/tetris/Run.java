package com.seleon.tetris;

import com.seleon.tetris.controller.Initializer;
import com.seleon.tetris.model.Game;

/**
 * @author Sergey Mikhluk.
 */
public class Run {
    public static void main(String[] args) {
        new Initializer();
        Game.getInstance().go();
    }
}

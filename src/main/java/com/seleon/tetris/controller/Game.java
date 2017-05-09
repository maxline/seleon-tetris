package com.seleon.tetris.controller;

import com.seleon.tetris.model.Figure;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    private static Game instance;
    private Figure figure;
    private final int SHOW_DELAY = 400; // delay for animation
    private boolean gameOver = false;

    public Game() {
          }

    public void go() {
        figure = new Figure();
        figure.place();
    }


    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
}

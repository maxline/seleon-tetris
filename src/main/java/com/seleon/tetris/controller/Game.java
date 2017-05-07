package com.seleon.tetris.controller;

import com.seleon.tetris.model.Figure;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    private Figure figure = new Figure();
    private final int SHOW_DELAY = 400; // delay for animation
    private boolean gameOver = false;

    public Game() {
          }

    public void go() {
        figure = new Figure();
    }
}

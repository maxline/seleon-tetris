package com.seleon.tetris.model;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    private static Game instance;
    private final int SHOW_DELAY = 400; // delay for animation

    private TetrisBoard tetrisBoard;
    private Figure figure;
    private boolean gameOver = false;

    private Game() {
        tetrisBoard = TetrisBoard.getInstance(); //todo переписать через dependency injection в конструкторе
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void go() {
        figure = new Figure();
    }

    public void moveLeft() {
        figure.move(-1);
    }

    public void moveRight() {
        figure.move(1);
    }

    public void moveDown() {
        figure.down();
    }

    public void onClick(Point point) {
        tetrisBoard.onClick(point);
    }


    //Getters and setters
    public TetrisBoard getTetrisBoard() {
        return tetrisBoard;
    }

    public Figure getFigure() {
        return figure;
    }
}

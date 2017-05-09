package com.seleon.tetris.model;

import com.seleon.tetris.view.TetrisWindow;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    private static Game instance;
    private final int SHOW_DELAY = 400; // delay for animation
    private TetrisWindow tetrisWindow;
    private TetrisBoard tetrisBoard;
    private Figure figure;
    private boolean gameOver = false;

    private Game() {
        tetrisWindow = TetrisWindow.getInstance(); //todo переписать через dependency injection в конструкторе
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
        windowRepaint();
    }

    public void moveLeft() {
        figure.move(-1);
        windowRepaint();
    }

    public void moveRight() {
        figure.move(1);
        windowRepaint();
    }

    public void moveDown() {
        figure.down();
        windowRepaint();
    }

    public void onClick(Point point) {
        tetrisBoard.onClick(point);
        windowRepaint();
    }

    private void windowRepaint() {
        tetrisWindow.repaint();
    }

    //Getters and setters
    public TetrisBoard getTetrisBoard() {
        return tetrisBoard;
    }

    public Figure getFigure() {
        return figure;
    }
}

package com.seleon.tetris.model;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    private static Game instance;
    private final int SHOW_DELAY = 400; // delay for animation

    private Board board;
    private Figure figure;
    private boolean gameOver = false;

    private Game() {
        board = Board.getInstance(); //todo переписать через dependency injection в конструкторе
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

    //Getters and setters
    public Board getBoard() {
        return board;
    }

    public Figure getFigure() {
        return figure;
    }
}

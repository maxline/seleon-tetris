package com.seleon.tetris.model;

import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    public static int FIGURE_Y = 0;
    private static Game instance;
    private final int SHOW_DELAY = 1000; // delay for animation
    private Board board;
    private Figure figure;
    private GameWindow gameWindow;
    private boolean gameOver = false;

    private Game() {
        board = Board.getInstance(); //todo переписать через dependency injection в конструкторе
        figure = new Figure();//// TODO: 12.05.2017
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }


    public void go() {
        for (int i = 0; i < 25; i++) {
            figure = new Figure();
            while (!gameOver) {
                try {
                    Thread.sleep(SHOW_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isTouchGround()) {
                    liveOnTheGround();
                    break;
                }
                moveDown();
                gameWindow.repaint();
                System.out.println(i);
            }

        }
    }

    private void liveOnTheGround() {
        System.out.println("live it on the ground");

    }

    private boolean isTouchGround() {
        if (figure.getFigureY() >= board.getBoard().length) {
            return true;
        }
        //todo для оптимизации проверять только когда фигура уже ниже максимальной по высоте занятой ячейки в шахте
        //todo все таки добавить arrayList в фигуру которая хранит координаты блоков, вместо постоянного вычисления
        // нижней правой левой точки путем прохода по всему массиву фигуры
        int startX = figure.getFigureX();
        int startY = figure.getFigureY();
        int sizeY = figure.getMaxY();
        int sizeX = figure.getWidth();
        for (int row = sizeY; row >=0; row--) {
            for (int col = 0; col < sizeX; col++) {
                if (board.getBoard()[row + startY+1][col + startX] +
                        figure.getShape()[row][col] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCellYXTouched() {
        return false; //todo
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

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
}

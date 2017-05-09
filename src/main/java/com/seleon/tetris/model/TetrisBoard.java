package com.seleon.tetris.model;

import com.seleon.tetris.config.Config;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class TetrisBoard {

    private static TetrisBoard instance;

    private int[][] board = new int[Config.BOARD_HEIGHT][Config.BOARD_WIDTH];

    private int x;  //todo
    private int y;  //todo

    private TetrisBoard() {
        board[0][0] = 1; //todo
        board[1][0] = 1;
        board[2][1] = 1;
        board[17][1] = 1;
        board[17][9] = 1;

    }

    public static TetrisBoard getInstance() {
        if (instance == null) {
            instance = new TetrisBoard();
        }
        return instance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getBoard() {
        return board;
    }

    public void decrementX(int value) {
        x -= value;
    }

    public void incrementX(int value) {
        x += value;
    }

    public void onClick(Point point) {
        x = point.x;
        y = point.y;
    }
}

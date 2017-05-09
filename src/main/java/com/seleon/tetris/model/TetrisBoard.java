package com.seleon.tetris.model;

import com.seleon.tetris.config.Config;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class TetrisBoard {

    private static TetrisBoard instance;

    private int[][] board = new int[Config.BOARD_HEIGHT][Config.BOARD_WIDTH];

    private int pointerX;  //todo
    private int pointerY;  //todo

    private TetrisBoard() {
//        board[0][0] = 1; //todo
//        board[1][0] = 1;
//        board[2][1] = 1;
//        board[17][1] = 1;
//        board[17][9] = 1;
    }

    public static TetrisBoard getInstance() {
        if (instance == null) {
            instance = new TetrisBoard();
        }
        return instance;
    }

    public void setCellValue(int cellY, int cellX, int value) {
        System.out.println("y=" + cellY + ", x=" + cellX);
        board[cellY][cellX] = value;
    }

    public int getX() {
        return pointerX;
    }

    public void setX(int x) {
        this.pointerX = x;
    }

    public int getY() {
        return pointerY;
    }

    public void setY(int y) {
        this.pointerY = y;
    }

    public int[][] getBoard() {
        return board;
    }

    public void decrementX(int value) {
        pointerX -= value;
    }

    public void incrementX(int value) {
        pointerX += value;
    }

    public void onClick(Point point) { //todo
        pointerX = point.x;
        pointerY = point.y;
    }
}

package com.seleon.tetris.model;

import com.seleon.tetris.config.Config;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class TetrisBoard {

    private static TetrisBoard instance;

    private int[][] board = new int[Config.BOARD_HEIGHT][Config.BOARD_WIDTH];

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

    public int[][] getBoard() {
        return board;
    }

}

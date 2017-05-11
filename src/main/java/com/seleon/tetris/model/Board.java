package com.seleon.tetris.model;

import com.seleon.tetris.config.Config;

/**
 * @author Sergey Mikhluk.
 */
public class Board {

    private static Board instance;

    private int[][] board = new int[Config.BOARD_HEIGHT][Config.BOARD_WIDTH];

    private Board() {
//        board[0][0] = 1; //todo
//        board[1][0] = 1;
//        board[2][1] = 1;
//        board[17][1] = 1;
//        board[17][9] = 1;
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
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
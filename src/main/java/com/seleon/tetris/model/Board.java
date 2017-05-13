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
        board[5][1] = 1;
        board[6][1] = 1;
        board[14][8] = 1;
        board[13][4] = 1;
        for (int col = 0; col < Config.BOARD_WIDTH; col++) {
            board[Config.BOARD_HEIGHT - 1][col] = 1;
        }
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

    public int getWidth() {
        return board[0].length;
    }

    public int getHeight() {
        return board.length;
    }
}

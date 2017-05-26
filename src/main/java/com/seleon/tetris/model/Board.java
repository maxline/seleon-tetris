package com.seleon.tetris.model;

import com.seleon.tetris.config.Config;

/**
 * @author Sergey Mikhluk.
 */
public class Board {

    public static final int COLOR_WHITE = 0xffffff;
    private static Board instance;

    private int[][] board;

    private Board() {
        reset();
    }

    public void reset() {
        board = new int[Config.BOARD_HEIGHT][Config.BOARD_WIDTH];
        //        board[0][0] = 1; //todo
        board[5][1] = COLOR_WHITE;
        board[6][1] = COLOR_WHITE;
        board[14][8] = COLOR_WHITE;
        board[13][4] = COLOR_WHITE;
        for (int col = 0; col < Config.BOARD_WIDTH; col++) {
            board[Config.BOARD_HEIGHT - 1][col] = COLOR_WHITE;
        }
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void setCellValue(int cellY, int cellX, int value) {
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

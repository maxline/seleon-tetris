package com.seleon.tetris.model;

import java.util.Random;

/**
 * @author Sergey Mikhluk.
 */
public class Figure {

    private final int[][][] SHAPES = {
            {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 0x00f0f0}}, // I
            {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {4, 0xf0f000}}, // O
            {{1, 0, 0, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0x0000f0}}, // J
            {{0, 0, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0xf0a000}}, // L
            {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0x00f000}}, // S
            {{1, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0xa000f0}}, // T
            {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0xf00000}}  // Z
    };

    private TetrisBoard tetrisBoard = TetrisBoard.getInstance();
    private int[][] shape = new int[4][4];
    private int type, size, color;

    private int figureX = 3; //todo
    private int figureY = 1;

    public Figure() {
        Random random = new Random(); //todo
        type = random.nextInt(SHAPES.length);
        size = SHAPES[type][4][0];
        color = SHAPES[type][4][1];
        if (size == 4) {
            //figureY = -1; todo
        }
        for (int i = 0; i < size; i++)
            System.arraycopy(SHAPES[type][i], 0, shape[i], 0, SHAPES[type][i].length);
    }


    public void move(int direction) {
        //if (!isTouchWall(direction)) {
        // int dx = direction - 38; // LEFT = -1, RIGHT = 1
        int dx = direction; // LEFT = -1, RIGHT = 1
        //for (Block block : figure) block.setX(block.getX() + dx);
        figureX += dx;
    }
    //}

//    public void place() {
//        for (int y = 0; y < shape.length; y++) {
//            for (int x = 0; x < shape[0].length; x++) {
//                tetrisBoard.setCellValue(figureY + y, figureX + x, shape[y][x]);
//            }
//        }
//    }

    public void down() {
        figureY++;
    }

    public int[][] getShape() {
        return shape;
    }

    public int getFigureX() {
        return figureX;
    }

    public int getFigureY() {
        return figureY;
    }
}

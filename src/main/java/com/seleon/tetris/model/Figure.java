package com.seleon.tetris.model;

import java.util.Random;

/**
 * @author Sergey Mikhluk.
 */
public class Figure {

    public static final int HEIGHT = 4;
    public static final int WIDTH = 4;
    private final int[][][] SHAPES = {
            {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 0x00f0f0}}, // I
            {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {4, 0xf0f000}}, // O
            {{1, 0, 0, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0x0000f0}}, // J
            {{0, 0, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0xf0a000}}, // L
            {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0x00f000}}, // S
            {{1, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0xa000f0}}, // T
            {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0xf00000}}  // Z
    };

    private Board board = Board.getInstance();
    private int[][] shape = new int[HEIGHT][WIDTH];
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
//                board.setCellValue(figureY + y, figureX + x, shape[y][x]);
//            }
//        }
//    }

    public int getMaxY(){
        for(int row = getHeight()-1; row>=0;row--){
            for(int col = 0; col< getWidth();col++){
                if (shape[row][col]>0){
                    return row;
                }
            }
        }
        return 0;
    }

    public void down() {
        figureY++;
    }

    public int[][] getShape() {
        return shape;
    }

    public int getFigureX() {
        return figureX;
    }

    public void setFigureX(int figureX) {
        this.figureX = figureX;
    }

    public int getFigureY() {
        return figureY;
    }

    public void setFigureY(int figureY) {
        this.figureY = figureY;
    }

    public int getWidth() {
        return shape.length;
    }

    public int getHeight() {
        return shape[0].length;
    }
}

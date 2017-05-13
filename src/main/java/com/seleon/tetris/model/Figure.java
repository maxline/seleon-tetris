package com.seleon.tetris.model;

import java.util.ArrayList;
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

    private ArrayList<Block> blocks = new ArrayList<Block>();
    private int[][] shape = new int[HEIGHT][WIDTH];
    private int type, size, color;

    private int figureX = 3; //todo
    private int figureY = 0;

    public Figure() {
        Random random = new Random(); //todo
        type = random.nextInt(SHAPES.length);
        size = SHAPES[type][4][0];
        color = SHAPES[type][4][1];
        if (size == 4) {
            //figureY = -1; todo
        }
        for (int i = 0; i < size; i++) {
            System.arraycopy(SHAPES[type][i], 0, shape[i], 0, SHAPES[type][i].length);
        }
        createBlocks();
    }

    private void createBlocks() {
        blocks.clear();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (shape[row][col] > 0) {
                    blocks.add(new Block(figureY + row, figureX + col));
                }
            }
        }
    }


    public void move(int direction) {
        int dx = direction; // LEFT = -1, RIGHT = 1
        for (Block block : blocks) {
            block.setX(block.getX() + dx);
        }
        figureX += dx;
    }

    public void down() {
        figureY++;
        for (Block block : blocks) {
            block.incrementY();
        }
    }

    public void rotate(boolean clockwise) {
        rotateShape(clockwise);
        createBlocks();
    }

    private void rotateShape(boolean clockWise) {
        for (int i = 0; i < size / 2; i++)
            for (int j = i; j < size - 1 - i; j++)
                if (clockWise) {
                    int tmp = shape[size - 1 - j][i];
                    shape[size - 1 - j][i] = shape[size - 1 - i][size - 1 - j];
                    shape[size - 1 - i][size - 1 - j] = shape[j][size - 1 - i];
                    shape[j][size - 1 - i] = shape[i][j];
                    shape[i][j] = tmp;
                } else {
                    int tmp = shape[i][j];
                    shape[i][j] = shape[j][size - 1 - i];
                    shape[j][size - 1 - i] = shape[size - 1 - i][size - 1 - j];
                    shape[size - 1 - i][size - 1 - j] = shape[size - 1 - j][i];
                    shape[size - 1 - j][i] = tmp;
                }
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

    public int getColor() {
        return color;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}

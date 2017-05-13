package com.seleon.tetris.model;

/**
 * @author Sergey Mikhluk.
 */
public class Block {
    int x;
    int y;

    public Block(int y, int x) {
        this.y = y;
        this.x = x;
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

    public void incrementY() {
        y++;
    }
}

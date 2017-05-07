package com.seleon.tetris.model;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class TetrisBoard {

    private static TetrisBoard instance;
    private int x;
    private int y;

    private TetrisBoard() {
    }

    public static TetrisBoard getInstance(){
        if (instance == null){
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

    public void decrementX(int value){
        x-= value;
    }
    public void incrementX(int value){
        x+= value;
    }

    public void onClick(Point point) {
        x = point.x;
        y = point.y;
    }
}

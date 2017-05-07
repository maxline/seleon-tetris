package com.seleon.tetris.model;

import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class Figure {
    private int x = 3; //todo
    private int y = 0;

    void move(int direction) {
        //if (!isTouchWall(direction)) {
           // int dx = direction - 38; // LEFT = -1, RIGHT = 1
            int dx = direction ; // LEFT = -1, RIGHT = 1
            //for (Block block : figure) block.setX(block.getX() + dx);
            x += dx;
        }
    //}

    void paint(Graphics g, int color) {
        g.setColor(new Color(color));
        //g.drawRoundRect(x*BLOCK_SIZE+1, y*BLOCK_SIZE+1, BLOCK_SIZE-2, BLOCK_SIZE-2, ARC_RADIUS, ARC_RADIUS);
    }

}

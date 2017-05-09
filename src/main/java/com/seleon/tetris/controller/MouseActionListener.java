package com.seleon.tetris.controller;

import com.seleon.tetris.model.TetrisBoard;
import com.seleon.tetris.view.TetrisWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Sergey Mikhluk.
 */
public class MouseActionListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        TetrisBoard.getInstance().onClick(e.getPoint());
        TetrisWindow.getInstance().repaint();
    }
}

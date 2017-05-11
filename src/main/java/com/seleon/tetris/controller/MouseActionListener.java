package com.seleon.tetris.controller;

import com.seleon.tetris.model.Game;
import com.seleon.tetris.view.TetrisWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Sergey Mikhluk.
 */
public class MouseActionListener extends MouseAdapter {
    private TetrisWindow tetrisWindow = TetrisWindow.getInstance(); //todo переписать через dependency injection в конструкторе

    @Override
    public void mouseClicked(MouseEvent e) {
        Game game = Game.getInstance();
        //game.onClick(e.getPoint());
        windowRepaint();
    }

    private void windowRepaint() {
        tetrisWindow.repaint();
    }
}
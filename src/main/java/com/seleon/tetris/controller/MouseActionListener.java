package com.seleon.tetris.controller;

import com.seleon.tetris.model.Game;
import com.seleon.tetris.view.game.GameWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Sergey Mikhluk.
 */
public class MouseActionListener extends MouseAdapter {
    private GameWindow gameWindow;

    public MouseActionListener(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Game game = Game.getInstance();
        //game.onClick(e.getPoint());
        windowRepaint();
    }

    private void windowRepaint() {
        gameWindow.repaint();
    }
}
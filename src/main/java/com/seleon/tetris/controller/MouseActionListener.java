package com.seleon.tetris.controller;

import com.seleon.tetris.model.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Sergey Mikhluk.
 */
public class MouseActionListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        Game game = Game.getInstance();
        game.onClick(e.getPoint());
    }
}

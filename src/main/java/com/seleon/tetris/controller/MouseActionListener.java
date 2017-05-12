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
    private Controller controller;

    public MouseActionListener(GameWindow gameWindow, Controller controller) {
        this.gameWindow = gameWindow;
        this.controller = controller;
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
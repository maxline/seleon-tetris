package com.seleon.tetris.controller.command;

import com.seleon.tetris.model.Game;

/**
 * @author Sergey Mikhluk.
 */
public  interface ICommand {
    Game game = Game.getInstance();

    void execute();
}
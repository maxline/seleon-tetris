package com.seleon.tetris.controller.command;

import com.seleon.tetris.model.Game;

/**
 * @author Sergey Mikhluk.
 */
abstract public  class AbstractCommand {
    protected Game game = Game.getInstance();

    abstract public void execute();
}
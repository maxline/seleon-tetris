package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class DownCommand implements ICommand {

    public void execute() {
        game.moveDown();
    }
}
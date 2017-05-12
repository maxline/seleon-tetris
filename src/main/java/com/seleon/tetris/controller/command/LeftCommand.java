package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class LeftCommand implements ICommand {

    public void execute() {
        game.moveLeft();
    }
}
package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class RightCommand implements ICommand {

    public void execute() {
        game.moveRight();
    }
}
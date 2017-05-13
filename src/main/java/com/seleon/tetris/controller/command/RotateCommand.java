package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class RotateCommand implements ICommand {

    public void execute() {
        game.rotate();
    }
}
package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class LeftCommand extends AbstractCommand {
    @Override
    public void execute() {
        game.moveLeft();
    }
}
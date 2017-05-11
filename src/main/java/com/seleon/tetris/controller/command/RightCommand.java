package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class RightCommand extends AbstractCommand {
    @Override
    public void execute() {
        game.moveRight();
    }
}
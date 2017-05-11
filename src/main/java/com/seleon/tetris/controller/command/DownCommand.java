package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class DownCommand extends AbstractCommand {
    @Override
    public void execute() {
        game.moveDown();
    }
}
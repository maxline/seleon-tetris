package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class SpaceCommand extends AbstractCommand {
    @Override
    public void execute() {
        game.go();
    }
}
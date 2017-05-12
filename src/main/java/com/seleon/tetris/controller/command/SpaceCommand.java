package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class SpaceCommand implements ICommand {

    public void execute() {
        game.go();
    }
}
package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class LevelCommand implements ICommand {

    public void execute() {
        game.level();
    }
}
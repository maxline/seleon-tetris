package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class QuitCommand implements ICommand {

    public void execute() {
        game.quit();
    }
}
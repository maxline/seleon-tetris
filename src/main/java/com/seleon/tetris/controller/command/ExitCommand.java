package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class ExitCommand implements ICommand {

    public void execute() {
        System.exit(0);
    }
}
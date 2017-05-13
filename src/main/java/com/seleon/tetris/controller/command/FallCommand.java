package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class FallCommand implements ICommand {

    public void execute() {
        //game.go();//todo
        game.fall();
    }
}
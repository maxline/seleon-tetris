package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class StartCommand implements ICommand {

    public void execute() {
        //todo не будут ли при нажатии Новая игра старые потоки оставаться в памяти? и непонятно что делать..
        //но если не запускать каждый раз новый поток, при старте новой игры, то не происходит вывод на экран, до тех пор
        //пока не отработает метод go до конца, в в нем находится вечный цикл, выход, только когда gameOver.
        new Thread(game).start();
    }
}
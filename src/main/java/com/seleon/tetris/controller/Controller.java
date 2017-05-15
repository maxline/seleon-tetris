package com.seleon.tetris.controller;

import com.seleon.tetris.controller.command.*;
import com.seleon.tetris.model.Game;
import com.seleon.tetris.view.game.GameWindow;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * @author Sergey Mikhluk.
 */
public class Controller {

    private final HashMap<Integer, ICommand> commands = new HashMap<Integer, ICommand>();
    private ICommand missingCommand = new MissingCommand();

    public Controller(GameWindow gameWindow) {
        commands.put(KeyEvent.VK_LEFT, new LeftCommand());
        commands.put(KeyEvent.VK_RIGHT, new RightCommand());
        commands.put(KeyEvent.VK_DOWN, new DownCommand());
        commands.put(KeyEvent.VK_SPACE, new FallCommand());
        commands.put(KeyEvent.VK_UP, new RotateCommand());
        commands.put(KeyEvent.VK_Q, new QuitCommand());
        commands.put(KeyEvent.VK_P, new PauseCommand());

        initListeners(gameWindow);
    }

    public void initListeners(GameWindow gameWindow) {
        gameWindow.getBoardPanel().addBoardMouseListener(new MouseActionListener(gameWindow, this));
        gameWindow.getBoardPanel().addBoardKeyListener(new KeyListener(gameWindow, this));
    }

    public ICommand getCommand(Integer keyEvent) {
        ICommand command = commands.get(keyEvent);

        if (command == null) {
            command = missingCommand;
        }

        if (Game.getInstance().isPause() && !(command instanceof PauseCommand || command instanceof QuitCommand)){
            command = missingCommand;
        }

        return command;
    }
}
package com.seleon.tetris.controller;

import com.seleon.tetris.controller.command.*;
import com.seleon.tetris.view.game.GameWindow;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * @author Sergey Mikhluk.
 */
public class Controller {

    private final HashMap<Integer, ICommand> commands = new HashMap<Integer, ICommand>();

    public Controller(GameWindow gameWindow) {
        commands.put(KeyEvent.VK_LEFT, new LeftCommand());
        commands.put(KeyEvent.VK_RIGHT, new RightCommand());
        commands.put(KeyEvent.VK_DOWN, new DownCommand());
        commands.put(KeyEvent.VK_SPACE, new SpaceCommand());

        initListeners(gameWindow);
    }

    public void initListeners(GameWindow gameWindow) {
        gameWindow.getBoardPanel().addBoardMouseListener(new MouseActionListener(gameWindow, this));
        gameWindow.getBoardPanel().addBoardKeyListener(new KeyListener(gameWindow, this));
    }

    public ICommand getCommand(Integer keyEvent) {
        ICommand command = commands.get(keyEvent);

        if (command == null) {
            command = new MissingCommand();
        }
        return command;
    }
}
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

    private final HashMap<String, ICommand> commands = new HashMap<>();
    private ICommand missingCommand = new MissingCommand();

    public Controller(GameWindow gameWindow) {
        commands.put(String.valueOf(KeyEvent.VK_LEFT), new LeftCommand());
        commands.put(String.valueOf(KeyEvent.VK_RIGHT), new RightCommand());
        commands.put(String.valueOf(KeyEvent.VK_DOWN), new DownCommand());
        commands.put(String.valueOf(KeyEvent.VK_SPACE), new FallCommand());
        commands.put(String.valueOf(KeyEvent.VK_UP), new RotateCommand());

        commands.put(String.valueOf(KeyEvent.VK_Q), new QuitCommand());
        commands.put(String.valueOf(KeyEvent.VK_P), new PauseCommand());
        commands.put(String.valueOf(KeyEvent.VK_X), new ExitCommand());
        commands.put(String.valueOf(KeyEvent.VK_S), new StartCommand());
        commands.put(String.valueOf(KeyEvent.VK_L), new LevelCommand());

        commands.put(GameWindow.MENU_START, new StartCommand());
        commands.put(GameWindow.MENU_LEVEL, new LevelCommand());
        commands.put(GameWindow.MENU_EXIT, new ExitCommand());

        initListeners(gameWindow);
    }

    public void initListeners(GameWindow gameWindow) {
        gameWindow.getBoardPanel().addBoardMouseListener(new MouseActionListener(gameWindow, this));
        gameWindow.getBoardPanel().addBoardKeyListener(new KeyListener(gameWindow, this));

        gameWindow.addMenuActionListener(new MenuActionListener(this));
    }

    public ICommand getCommand(String eventCommand) {
        ICommand command = commands.get(String.valueOf(eventCommand));

        if (command == null) {
            command = missingCommand;
        }

        if (Game.getInstance().isPause() &&
                !(command instanceof PauseCommand ||
                        command instanceof QuitCommand ||
                        command instanceof StartCommand
                )){
            command = missingCommand;
        }

        return command;
    }
}
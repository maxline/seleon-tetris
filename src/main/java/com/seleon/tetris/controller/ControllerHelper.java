package com.seleon.tetris.controller;

import com.seleon.tetris.controller.command.*;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * @author Sergey Mikhluk.
 */
public class ControllerHelper {

    private static ControllerHelper instance;
    private final HashMap<Integer, AbstractCommand> commands = new HashMap<Integer, AbstractCommand>();

    private ControllerHelper() {
        commands.put(KeyEvent.VK_LEFT, new LeftCommand());
        commands.put(KeyEvent.VK_RIGHT, new RightCommand());
        commands.put(KeyEvent.VK_DOWN, new DownCommand());
        commands.put(KeyEvent.VK_SPACE, new SpaceCommand());
    }

    public AbstractCommand getCommand(Integer keyEvent) {
        AbstractCommand command = commands.get(keyEvent);

        if (command == null) {
            command = new MissingCommand();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
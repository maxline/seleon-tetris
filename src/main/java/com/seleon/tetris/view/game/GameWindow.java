package com.seleon.tetris.view.game;

import javax.swing.*;
import java.awt.*;

import static com.seleon.tetris.config.Config.*;

/**
 * @author Sergey Mikhluk.
 */
public class GameWindow extends JFrame {
    private static final int MAIN_WINDOW_WIDTH = BOARD_WIDTH * BLOCK_SIZE + 8;
    private static final int MAIN_WINDOW_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE + 30;
    private static GameWindow instance;

    private GameWindow() {
        super(GAME_WINDOW_TITLE);

        createMainFrame();
        display();
    }

    public static GameWindow getInstance() {
        if (instance == null) {
            instance = new GameWindow();
        }
        return instance;
    }

    private void createMainFrame() {
        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().add(BoardPanel.getInstance(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        setVisible(true);
    }
}

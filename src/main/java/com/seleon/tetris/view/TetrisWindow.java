package com.seleon.tetris.view;

import javax.swing.*;
import java.awt.*;

import static com.seleon.tetris.config.Config.*;

/**
 * @author Sergey Mikhluk.
 */
public class TetrisWindow extends JFrame {
    private static TetrisWindow instance;

    private static final int MAIN_WINDOW_WIDTH = BOARD_WIDTH * BLOCK_SIZE + 8;
    private static final int MAIN_WINDOW_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE + 30;

    private TetrisWindow() {
        super(MAIN_WINDOW_TITLE);

        createMainFrame();
        display();
    }

    private void createMainFrame() {
        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        //setFocusable(true);
        getContentPane().add(MinePanel.getInstance(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TetrisBoard.getInstance();
        //setLocation(100, 100);
        //minePanel.setFocusable(true);
    }

    private void display() {
        setVisible(true);
    }

    public static TetrisWindow getInstance() {
        if (instance == null) {
            instance = new TetrisWindow();
        }
        return instance;
    }
}

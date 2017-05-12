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
    private BoardPanel boardPanel = new BoardPanel();

    public GameWindow() {
        super(GAME_WINDOW_TITLE);

        createMainFrame();
        display();
    }

    private void createMainFrame() {
        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().add(boardPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        setVisible(true);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }
}

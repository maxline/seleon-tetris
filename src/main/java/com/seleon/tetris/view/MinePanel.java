package com.seleon.tetris.view;

import com.seleon.tetris.controller.KeyActionListener;
import com.seleon.tetris.controller.MouseActionListener;
import com.seleon.tetris.model.TetrisBoard;

import javax.swing.*;
import java.awt.*;

import static com.seleon.tetris.config.Config.*;

/**
 * @author Sergey Mikhluk.
 */
public class MinePanel extends JPanel {
    private static MinePanel instance;

    private static final int MINE_PANEL_WIDTH = BOARD_WIDTH * BLOCK_SIZE;
    private static final int MINE_PANEL_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE;

    private MinePanel() {
        setOpaque(true);
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(Color.red));
        setBackground(Color.BLACK);
        setSize(MINE_PANEL_WIDTH, MINE_PANEL_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.WHITE);
        TetrisBoard tetrisBoard = TetrisBoard.getInstance();
        //graphics.drawRoundRect(1, 20, 50, 20, ARC_WIDTH, ARC_HEIGHT);

        for (int y = 0; y < tetrisBoard.getBoard().length; y++) {
            for (int x = 0; x < tetrisBoard.getBoard()[0].length; x++) {
                if (tetrisBoard.getBoard()[y][x] > 0) {
                    graphics.drawRoundRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE - 1 , BLOCK_SIZE - 1, ARC_WIDTH, ARC_HEIGHT);
                }
            }
        }

        graphics.drawOval(tetrisBoard.getX(), tetrisBoard.getY(), BLOCK_SIZE - 1 , BLOCK_SIZE - 1);
        System.out.println(tetrisBoard.getX());
        System.out.println(tetrisBoard.getY());

    }

    public void addBoardKeyListener(KeyActionListener keyActionListener) {
        addKeyListener(keyActionListener);
    }

    public void addBoardMouseListener(MouseActionListener mouseActionListener) {
        addMouseListener(mouseActionListener);
    }

    public static MinePanel getInstance() {
        if (instance == null) {
            instance = new MinePanel();
        }
        return instance;
    }
}

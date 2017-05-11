package com.seleon.tetris.view;

import com.seleon.tetris.controller.KeyActionListener;
import com.seleon.tetris.controller.MouseActionListener;
import com.seleon.tetris.model.Figure;
import com.seleon.tetris.model.Game;
import com.seleon.tetris.model.TetrisBoard;

import javax.swing.*;
import java.awt.*;

import static com.seleon.tetris.config.Config.*;

/**
 * @author Sergey Mikhluk.
 */
public class MinePanel extends JPanel {
    private static final int MINE_PANEL_WIDTH = BOARD_WIDTH * BLOCK_SIZE;
    private static final int MINE_PANEL_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE;
    private static MinePanel instance;

    private MinePanel() {
        setOpaque(true);
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(Color.red));
        setBackground(Color.BLACK);
        setSize(MINE_PANEL_WIDTH, MINE_PANEL_HEIGHT);
    }

    public static MinePanel getInstance() {
        if (instance == null) {
            instance = new MinePanel();
        }
        return instance;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.WHITE);
        Game game = Game.getInstance(); //todo должно инжектиться?

        drawBoard(graphics, game);
        drawFigure(graphics, game);
    }

    private void drawFigure(Graphics graphics, Game game) {
        Figure figure = game.getFigure();
        if (figure == null || figure.getShape() == null) {
            return;
        }

        for (int y = 0; y < figure.getShape().length; y++) {
            for (int x = 0; x < figure.getShape()[0].length; x++) {
                if (figure.getShape()[y][x] > 0) {
                    graphics.drawRoundRect((x + figure.getFigureX()) * BLOCK_SIZE, (y + figure.getFigureY()) * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1, ARC_WIDTH, ARC_HEIGHT);
                }
            }
        }
    }

    private void drawBoard(Graphics graphics, Game game) {
        TetrisBoard tetrisBoard = game.getTetrisBoard();

        for (int y = 0; y < tetrisBoard.getBoard().length; y++) {
            for (int x = 0; x < tetrisBoard.getBoard()[0].length; x++) {
                if (tetrisBoard.getBoard()[y][x] > 0) {
                    graphics.drawRoundRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1, ARC_WIDTH, ARC_HEIGHT);
                }
            }
        }

        graphics.drawOval(tetrisBoard.getX(), tetrisBoard.getY(), BLOCK_SIZE - 1, BLOCK_SIZE - 1);
        System.out.println(tetrisBoard.getX());
        System.out.println(tetrisBoard.getY());
    }

    public void addBoardKeyListener(KeyActionListener keyActionListener) {
        addKeyListener(keyActionListener);
    }

    public void addBoardMouseListener(MouseActionListener mouseActionListener) {
        addMouseListener(mouseActionListener);
    }
}

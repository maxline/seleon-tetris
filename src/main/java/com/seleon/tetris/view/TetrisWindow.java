package com.seleon.tetris.view;

import com.seleon.tetris.controller.KeyActionListener;
import com.seleon.tetris.controller.MouseActionListener;
import com.seleon.tetris.model.TetrisBoard;

import javax.swing.*;
import java.awt.*;

/**
 * @author Sergey Mikhluk.
 */
public class TetrisWindow extends JFrame {
    private static final String MAIN_WINDOW_TITLE = "Tetris";
    private static final int MAIN_WINDOW_WIDTH = 200;
    private static final int MAIN_WINDOW_HEIGHT = 400;

    private JPanel mainPanel;

    public TetrisWindow()  {
        super(MAIN_WINDOW_TITLE);
        createMainFrame();
        display();
    }

    private void createMainFrame() {
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        mainPanel.setBackground(Color.BLACK);

        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TetrisBoard.getInstance();
        //setLocation(100, 100);
        //mainPanel.setFocusable(true);
    }

    private void display() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.WHITE);
        graphics.drawOval(TetrisBoard.getInstance().getX(), TetrisBoard.getInstance().getY(), 10, 10);
    }

    public void addBoardKeyListener(KeyActionListener keyActionListener) {
        addKeyListener(keyActionListener);
    }

    public void addBoardMouseListener(MouseActionListener mouseActionListener){
        addMouseListener(mouseActionListener);
    }
}

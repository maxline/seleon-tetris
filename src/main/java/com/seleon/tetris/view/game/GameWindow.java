package com.seleon.tetris.view.game;

import com.seleon.tetris.controller.MenuActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static com.seleon.tetris.config.Config.*;

/**
 * @author Sergey Mikhluk.
 */
public class GameWindow extends JFrame {
    private static final int MAIN_WINDOW_WIDTH = BOARD_WIDTH * BLOCK_SIZE + 158;
    private static final int MAIN_WINDOW_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE + 50;
    public static final String MENU_HELP = "Help";
    public static final String MENU_EXIT = "Exit";
    public static final String MENU_LEVEL = "Level";
    public static final String MENU_START = "Start";

    private JMenu mainMenu;
    private JPanel mailPanel;
    private BoardPanel boardPanel;
    private StatusPanel statusPanel;

    public GameWindow() {
        super(GAME_WINDOW_TITLE);

        createMenu();
        createPanels();
        createMainFrame();
        display();
    }

    private void createPanels() {
        boardPanel = new BoardPanel();
        statusPanel = new StatusPanel();

        mailPanel = new JPanel(new BorderLayout(10, 10));
        mailPanel.add(boardPanel,  BorderLayout.CENTER);
        mailPanel.add(statusPanel, BorderLayout.EAST);
    }

    private void createMenu()  {
        mainMenu = new JMenu("Menu"); //todo string constants

        JMenuItem menuStart = new JMenuItem(MENU_START);
        menuStart.setActionCommand(MENU_START);
        menuStart.setMnemonic(KeyEvent.VK_S);

        JMenuItem menuLevel = new JMenuItem(MENU_LEVEL);
        menuLevel.setActionCommand(MENU_LEVEL);
        menuLevel.setMnemonic(KeyEvent.VK_L);

        JMenuItem menuHelp = new JMenuItem(MENU_HELP);
        menuHelp.setActionCommand(MENU_HELP);
        menuHelp.setMnemonic(KeyEvent.VK_H);

        JMenuItem menuExit = new JMenuItem(MENU_EXIT);
        menuExit.setActionCommand(MENU_EXIT);
        menuExit.setMnemonic(KeyEvent.VK_E);

        mainMenu.add(menuStart);
        mainMenu.add(menuLevel);
        mainMenu.addSeparator();
        mainMenu.add(menuHelp);
        mainMenu.add(menuExit);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(mainMenu);
        setJMenuBar(menuBar);
    }

    private void createMainFrame() {
        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().add(mailPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        setVisible(true);
    }

    public void addMenuActionListener(MenuActionListener menuActionListener) {
        addMenuItemActionListener(menuActionListener, mainMenu);
        //addMenuItemActionListener(menuActionListener, fileMenu); todo
    }

    public void addMenuItemActionListener(MenuActionListener menuActionListener, JMenu menu) {
        for (int i = 0; i < menu.getItemCount(); i++) {
            JMenuItem menuItem = menu.getItem(i);
            if (menuItem != null) {
                menu.getItem(i).addActionListener(menuActionListener);
            }
        }
    }

    //getters and setters
    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

}

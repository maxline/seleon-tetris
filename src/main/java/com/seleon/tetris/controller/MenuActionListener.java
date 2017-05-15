package com.seleon.tetris.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Sergey Mikhluk.
 */
public class MenuActionListener implements ActionListener {

    private Controller controller;

    public MenuActionListener(Controller controller) {
        this.controller = controller;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        controller.getCommand(menuItem.getActionCommand()).execute();
    }
}

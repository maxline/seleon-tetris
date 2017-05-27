package com.seleon.tetris.view.game;

import com.seleon.tetris.model.Game;

import javax.swing.*;
import java.awt.*;

import static com.seleon.tetris.config.Config.BLOCK_SIZE;
import static com.seleon.tetris.config.Config.BOARD_HEIGHT;

/**
 * @author Sergey Mikhluk.
 */
public class StatusPanel extends JPanel {
    private static final int STATUS_PANEL_WIDTH = 100;
    private static final int STATUS_PANEL_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE;

    private JLabel scoreLabel;
    private JLabel levelLabel;
    private JLabel statusLabel;

    public StatusPanel() {
        setLayout(new GridLayout(16, 1));
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.red));

        createLables();
    }

    private void createLables() {
        scoreLabel = createLabel("");
        add(createLabel("Score"));
        add(scoreLabel);

        levelLabel = createLabel("");
        add(createLabel("Level"));
        add(levelLabel);

        statusLabel = createLabel("");
        add(createLabel("Status"));
        add(statusLabel);
    }

    private JLabel createLabel(String caption) {
        JLabel label = new JLabel(caption);
        label.setPreferredSize(new Dimension(100, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        return label;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawScore();
        drawLevel();
        drawStatus();
    }

    private void drawScore() {
        scoreLabel.setText(String.valueOf(Game.getInstance().getScore()));
    }

    private void drawLevel() {
        levelLabel.setText(String.valueOf(Game.getInstance().getLevel()));
    }
    private void drawStatus() {
        statusLabel.setText(String.valueOf(Game.getInstance().getStatusMessage()));
    }
}

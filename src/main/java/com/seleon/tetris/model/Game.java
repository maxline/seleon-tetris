package com.seleon.tetris.model;

import com.seleon.tetris.view.game.GameWindow;

import java.util.Objects;

import static com.seleon.tetris.config.Config.CLOCK_WISE;
import static com.seleon.tetris.config.Config.SCORES;

/**
 * @author Sergey Mikhluk.
 */
public class Game implements Runnable {

    private static final String STATUS_GAME_OVER = "Game over!";
    private static final String STATUS_PAUSED = "Paused";
    private static final String STATUS_TOUCH_WALL = "Touch wall!";
    private static final String STATUS_WRONG_POSITION = "Wrong position!";
    private final int SHOW_DELAY = 80;
    private final int MAX_LEVEL = 10;
    private static volatile Game instance;

    private Board board;
    private Figure figure;
    private GameWindow gameWindow;

    private boolean isGameOver = true;
    private boolean isPause = false;
    private int score;
    private int level;
    private String statusMessage;

    private Game() {
        board = Board.getInstance(); //todo переписать через dependency injection в конструкторе
    }

    public static Game getInstance() {
        Game localInstance = instance;
        if (localInstance == null) {
            synchronized (Game.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Game();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void run() {
        if (isGameOver) {
            go();
        } else {
            reset();
        }
    }

    public void go() {
        reset();
        while (!isGameOver) {
            try {
                Thread.sleep(getStepDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!isPause) {
                statusMessage = "";
                if (isTouchGround()) {
                    leaveOnTheGround();
                    checkFilling();

                    figure = new Figure();
                    if (isCrossGround()) {
                        statusMessage = STATUS_GAME_OVER;
                        isGameOver = true;
                    }
                } else {
                    moveDown();
                }

                if (Objects.equals(statusMessage, "")) {
                    statusMessage = "y " + figure.getFigureY() + ", x " + figure.getFigureX();
                }
                gameWindow.repaint();
            }
        }
        statusMessage = STATUS_GAME_OVER;
    }

    private void reset() {
        score = 0;
        level = 0;
        isGameOver = false;
        isPause = false;
        statusMessage = "";
        figure = new Figure();
        board.reset();
        gameWindow.repaint();
    }

    private int getStepDelay() {
        return (MAX_LEVEL - level) * SHOW_DELAY;
    }

    public void moveDown() {
        if (!isTouchGround()) {
            figure.down();
        }
    }

    public void fallQuick() {
        while (!isTouchGround()) {
            moveDown();
        }
        leaveOnTheGround();
    }

    private void leaveOnTheGround() {
        statusMessage = "Leave it on the ground";
        System.out.println("leave it on the ground");
        for (Block block : figure.getBlocks()) {
            board.setCellValue(block.getY(), block.getX(), figure.getColor());
        }
    }

    private boolean isTouchGround() {
        if (figure.getFigureY() >= board.getBoard().length) {
            return true;
        }

        for (Block block : figure.getBlocks()) {
            if (board.getBoard()[block.getY() + 1][block.getX()] > 0) {
                return true;
            }
        }

        return false;
    }

    private boolean isCrossGround() {
        for (Block block : figure.getBlocks()) {
            if (board.getBoard()[block.getY()][block.getX()] > 0) {
                return true;
            }
        }
        return false;
    }

    public void moveLeft() {
        if (!isTouchWall(-1)) {
            figure.move(-1);
        } else {
            statusMessage = STATUS_TOUCH_WALL;
        }
    }

    public void moveRight() {
        if (!isTouchWall(1)) {
            figure.move(1);
        } else {
            statusMessage = STATUS_TOUCH_WALL;
        }
    }

    private boolean isTouchWall(int dx) {
        for (Block block : figure.getBlocks()) {
            if (dx < 0 && block.getX() <= 0) {
                return true;
            } else if (dx > 0 && block.getX() >= board.getWidth() - 1) {
                return true;
            }
            if (board.getBoard()[block.getY()][block.getX() + dx] > 0) {
                return true;
            }
        }
        return false;
    }

    public void rotate() {
        figure.rotate(CLOCK_WISE);
        if (isWrongPosition()) {
            statusMessage = STATUS_WRONG_POSITION;
            figure.rotate(!CLOCK_WISE);
        }
    }

    private boolean isWrongPosition() {
        for (Block block : figure.getBlocks()) {
            if (block.getX() < 0 || block.getX() >= board.getWidth() || block.getY() > board.getHeight()) {
                return true;
            }

            if (board.getBoard()[block.getY()][block.getX()] > 0) {
                return true;
            }
        }
        return false;
    }

    void checkFilling() {
        int row = board.getHeight() - 2; //todo -1
        int countFillRows = 0;
        while (row > 0) {
            int filled = 1;
            for (int col = 0; col < board.getWidth(); col++)
                filled *= Integer.signum(board.getBoard()[row][col]);
            if (filled > 0) {
                countFillRows++;
                for (int i = row; i > 0; i--)
                    System.arraycopy(board.getBoard()[i - 1], 0, board.getBoard()[i], 0, board.getWidth());
            } else
                row--;
        }
        if (countFillRows > 0) {
            score += SCORES[countFillRows - 1];
        }
    }

    public void increaseLevel() {
        if (level < MAX_LEVEL - 1) {
            level++;
        }
    }

    public void pause() {
        isPause = !isPause;
        if (isPause) {
            statusMessage = STATUS_PAUSED;
        }
    }

    public void quit() {
        statusMessage = STATUS_GAME_OVER;
        isGameOver = true;
    }

    //Getters and setters
    public Board getBoard() {
        return board;
    }

    public Figure getFigure() {
        return figure;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public boolean isPause() {
        return isPause;
    }
}

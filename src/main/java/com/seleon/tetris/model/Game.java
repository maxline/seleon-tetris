package com.seleon.tetris.model;

import com.seleon.tetris.view.game.GameWindow;

/**
 * @author Sergey Mikhluk.
 */
public class Game {
    public static int FIGURE_Y = 0;
    private static Game instance;
    private final int SHOW_DELAY = 1000; // delay for animation
    private Board board;
    private Figure figure;
    private GameWindow gameWindow;
    private boolean gameOver = false;

    private Game() {
        board = Board.getInstance(); //todo переписать через dependency injection в конструкторе
        figure = new Figure();//// TODO: 12.05.2017
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }


    public void go() {
        for (int i = 0; i < 25; i++) {
            figure = new Figure();
            while (!gameOver) {
                try {
                    Thread.sleep(SHOW_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isTouchGround()) {
                    liveOnTheGround();
                    break;
                }
                moveDown();
                gameWindow.repaint();
                System.out.println(i);
            }

        }
    }

    private void liveOnTheGround() {
        System.out.println("live it on the ground");
        for(Block block: figure.getBlocks()){
            board.setCellValue(block.getY(), block.getX(), 1);
        }

    }

    private boolean isTouchWall(int dx) {
        for (Block block : figure.getBlocks()) {
            if(dx<0 && block.getX()<=0){
                return true;
            }else if(dx>0 && block.getX()>= board.getWidth()-1 ){
                return true;
            }
            if (board.getBoard()[block.getY()][block.getX() + dx] > 0) {
                return true;
            }
        }
        return false;

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
        //todo для оптимизации проверять только когда фигура уже ниже максимальной по высоте занятой ячейки в шахте
        return false;
    }

    private boolean isCellYXTouched() {
        return false; //todo
    }

    public void moveLeft() {
        if (!isTouchWall(-1)) {
            figure.move(-1);
        } else {
            System.out.println("Touch wall!");
        }
    }

    public void moveRight() {
        if (!isTouchWall(1)) {
            figure.move(1);
        } else {
            System.out.println("Touch wall!");

        }
    }

    public void moveDown() {
        figure.down();
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
}

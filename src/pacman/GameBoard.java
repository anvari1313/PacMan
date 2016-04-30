package pacman;

import pacman.characater.Character;
import pacman.characater.ghost.Ghost;
import pacman.characater.ghost.PinkGhost;
import pacman.characater.ghost.RedGhost;
import pacman.characater.ghost.YellowGhost;
import pacman.characater.pac.Pac;
import pacman.characater.staticchars.StaticChar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by ahmad on 4/28/16.
 */
public class GameBoard extends DoubleBuffer {
    private Pac pac;
    private ArrayList<Ghost> ghosts;
    private StaticChar [][]board;
    private int boardColNum;
    private int boardRowNum;

    public GameBoard(){
        super();
        MapLoader mapLoader = new MapLoader();
        mapLoader.loadFromFile();
        boardRowNum = mapLoader.getRow();
        boardColNum = mapLoader.getCol();
        board = mapLoader.loadMap();
        setSize(mapLoader.getCol()* Character.WIDTH,mapLoader.getRow()*Character.HEIGHT);
        setBackground(Color.BLUE);
        pac = mapLoader.getPac();
        ghosts = mapLoader.getGhosts();

        (new Repainter(this)).start();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println("log");
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()){
                    case KeyEvent.VK_UP:
                        pac.moveUp();
                        break;
                    case KeyEvent.VK_LEFT:
                        pac.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        pac.moveRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        pac.moveDown();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
    }

    @Override
    public void paintBuffer(Graphics g) {
        for (int i = 0; i < boardColNum; i++) {
            for (int j = 0; j < boardRowNum; j++) {
                g.drawImage(board[j][i].getImage(),board[j][i].getX(),board[j][i].getY(),board[j][i].getWidth(),board[j][i].getHeight(),null);
            }
        }

        if (pac.getImage() != null)
            g.drawImage(pac.getImage(),pac.getX(),pac.getY(),pac.getWidth(),pac.getHeight(),null);

        for (Ghost ghost : ghosts) {
            if (ghost.getImage() != null)
                g.drawImage(ghost.getImage(), ghost.getX(), ghost.getY(), ghost.getWidth(), ghost.getHeight(), null);
        }
    }
}

class Repainter extends Thread{
    GameBoard gameBoard;
    public Repainter(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }
    @Override
    public void run() {
        while (true){
            gameBoard.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
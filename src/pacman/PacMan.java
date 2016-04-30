package pacman;

import javax.swing.*;

/**
 * Created by ahmad on 4/28/16.
 */
public class PacMan {
    public static final String resourcePath = "resource/";
    public static final String ghostImageFilePath = "resource/image/ghost/";
    public static final String mapFilePath = "resource/maps/";
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame();
                GameBoard gameBoard = new GameBoard();
                jFrame.setSize(gameBoard.getSize());
                gameBoard.setLocation(0,0);
                jFrame.add(gameBoard);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}

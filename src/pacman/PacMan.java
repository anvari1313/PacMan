package pacman;

import javax.swing.*;

/**
 * Created by ahmad on 4/28/16.
 */
public class PacMan {
    public static final String resourcePath = "resource/";
    public static final String ghostImageFilePath = "resource/image/ghost/";
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setSize(600,700);
                jFrame.add(new GameBoard());
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}

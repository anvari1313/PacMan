package pacman;

import javax.swing.*;

/**
 * Created by ahmad on 4/28/16.
 */
public class PacMan {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setSize(600,700);
                jFrame.add(new GameBoard());
                jFrame.setVisible(true);
            }
        });
    }
}

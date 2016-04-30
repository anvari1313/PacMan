package pacman.characater.staticchars;

import pacman.PacMan;
import pacman.characater.Character;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by ahmad on 4/30/16.
 */
public class Wall extends StaticChar {
    public Wall(int x, int y){
        super(x,y);
        try {
            image = ImageIO.read(new File(PacMan.resourcePath + "homes/wall.png"));
        } catch (IOException e) {
            System.err.println("Wall image not found");
        }
    }
    @Override
    public void run() {
        ;
    }
}

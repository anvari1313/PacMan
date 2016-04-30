package pacman.characater.staticchars;

import pacman.PacMan;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by ahmad on 4/30/16.
 */
public class Home extends StaticChar {
    public Home(int x, int y) {
        super(x, y);
        try {
            image = ImageIO.read(new File(PacMan.resourcePath + "homes/food1.png"));
        } catch (IOException e) {
            System.err.println("Food image not found");
        }
    }

    public void emptyHome(){
        try {
            image = ImageIO.read(new File(PacMan.resourcePath + "homes/food1.png"));
        } catch (IOException e) {
            System.err.println("Food image not found");
        }
    }
}

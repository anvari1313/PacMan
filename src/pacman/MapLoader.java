package pacman;

import pacman.characater.Character;
import pacman.characater.ghost.Ghost;
import pacman.characater.ghost.PinkGhost;
import pacman.characater.ghost.RedGhost;
import pacman.characater.ghost.YellowGhost;
import pacman.characater.pac.Pac;
import pacman.characater.staticchars.Home;
import pacman.characater.staticchars.StaticChar;
import pacman.characater.staticchars.Wall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ahmad on 4/30/16.
 */
public class MapLoader {
    private int col;
    private int row;
    private String []rows;
    private StaticChar [][]map;
    private ArrayList<Ghost> ghosts;
    private Pac pac;

    public MapLoader(){
        ghosts = new ArrayList<>();
    }
    public void loadFromFile(){
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new File(PacMan.mapFilePath + "mymap.mp"));
        } catch (FileNotFoundException e) {
            System.err.println("Map file cannot be loaded from the file");
            fileScanner = null;
            System.exit(-1);
        }
        row = fileScanner.nextInt();
        col = fileScanner.nextInt();

        map = new StaticChar[row][col];
        fileScanner.nextLine();
        rows = new String[row];
        for (int i = 0; i < row; i++) {
            rows[i] = fileScanner.nextLine();
            System.out.println("-"+rows[i]+"-");
        }

        //  A temp instructing for getting the width and height
        int width = Character.WIDTH;
        int height = Character.HEIGHT;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                switch (rows[i].charAt(j)){
                    case '1':
                        map[i][j] = new Home(j * width, i * height,false);
                        break;
                    case 'b':
                        map[i][j] = new Wall(j * width, i * height);
                        break;
                    case 'r':
                        map[i][j] = new Home(j * width, i * height,false);
                        ghosts.add(new RedGhost(j * width, i * height));
                        break;
                    case 'y':
                        map[i][j] = new Home(j * width, i * height,false);
                        ghosts.add(new YellowGhost(j * width, i * height));
                        break;
                    case 'p':
                        map[i][j] = new Home(j * width, i * height,false);
                        ghosts.add(new PinkGhost(j * width, i * height));
                        break;
                    case 'x':
                        pac = new Pac(j * width, i * height);
                        map[i][j] = new Home(j * width, i * height,true);
                        break;

                }
            }
        }

        // Error checking
        if (pac == null)
            System.err.println("No pacman detected in the file");

    }

    public StaticChar [][] loadMap(){
        return this.map;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public ArrayList<Ghost> getGhosts(){
        return ghosts;
    }

    public Pac getPac(){
        return pac;
    }
}

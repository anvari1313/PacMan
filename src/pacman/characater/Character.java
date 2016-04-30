package pacman.characater;

import java.awt.*;

/**
 * Created by ahmad on 4/28/16.
 */
public abstract class Character extends Thread {
    protected Image image;
    protected final int CHANGE_STYLE_INTERVAL = 200;
    private int x;
    private int y;
    private int dX;
    private int dY;

    private int width;
    private int height;
    public enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN
    }

    protected Direction direction;

    public Character(int x, int y){
        width = 30;
        height = 30;
        this.x = x;
        this.y = y;
        dX = 15;
        dY = 15;
    }

    public void moveRight(){
        direction = Direction.RIGHT;
        x += dX;
    }

    public void moveLeft(){
        direction = Direction.LEFT;
        x -= dX;
    }

    public void moveUp(){
        direction = Direction.UP;
        y -= dY;
    }

    public void moveDown(){
        direction = Direction.DOWN;
        y += dY;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void run();

    public Image getImage(){
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

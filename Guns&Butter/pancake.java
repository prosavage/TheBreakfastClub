import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pancake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pancake extends Actor
{
    /**
     * Act - do whatever the pancake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.doMoveControls();


    }

    public void doMoveControls() {
        if (Greenfoot.isKeyDown("left")) {
            this.turn(5);
        } else if (Greenfoot.isKeyDown("right")) {
            this.turn(-5);
        } else if (Greenfoot.isKeyDown("down")) {
            this.move(1);
        } else if (Greenfoot.isKeyDown("up")) {
            this.move(-1);
        }
    }
}

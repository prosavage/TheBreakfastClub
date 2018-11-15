import greenfoot.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {
        // Create a new world with 800x800 cells with a cell size of 1x1 pixels.
        
        super(800, 800, 1, false);
        setBackground(new GreenfootImage("Background.jpg"));
        addObject(new waffle(), 200, 200);
        addObject(new pancake(), 400, 400);
        addObject(new whitebar(), 400, 25);
    }
    
    public void act(){
        if (Greenfoot.getRandomNumber(1000) <= 1) {
            addObject(new butterPowerUp(), Greenfoot.getRandomNumber(700) + 50, Greenfoot.getRandomNumber(700) + 50);
        }
        if (Greenfoot.getRandomNumber(1000) <= 1) {
            addObject(new healthUp(), Greenfoot.getRandomNumber(700) + 50, Greenfoot.getRandomNumber(700) + 50);
        }
    }
}

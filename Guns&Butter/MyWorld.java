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
        // Create a new world with 500x500 cells with a cell size of 1x1 pixels.
        super(500, 500, 1);
        addObject(new waffle(), 200, 200);
        addObject(new pancake(), 400, 400);
    }
}

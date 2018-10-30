
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Write a description of class waffle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class waffle extends Actor
{
    /**
     * Act - do whatever the waffle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("a")) {
            this.turn(5);
        } else if (Greenfoot.isKeyDown("d")) {
            this.turn(-5);
        } else if (Greenfoot.isKeyDown("w")) {
            this.move(1);
        } else if (Greenfoot.isKeyDown("s")) {
            this.move(-1);
        }




    }    
}

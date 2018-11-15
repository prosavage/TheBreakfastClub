import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthUp extends Actor
{   
    private int healthUpCounter = 400;
    /**
     * Act - do whatever the healthUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here:
        healthUpCounter--;
        if (healthUpCounter == 0){
            getWorld().removeObject(this);
        }
      
    }    
}

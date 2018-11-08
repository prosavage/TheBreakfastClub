import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class butterPowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class butterPowerUp extends Actor
{   
    private int butterPowerUpCounter = 400;
    /**
     * Act - do whatever the butterPowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        butterPowerUpCounter--;
        if (butterPowerUpCounter == 0){
            getWorld().removeObject(this);
        }
    }    
}

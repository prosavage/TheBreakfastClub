import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Butter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Butter extends Actor
{
    /**
     * Act - do whatever the Butter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    private int rotation;
    private GreenfootImage butterShot = new GreenfootImage("butterShot.png");
    public Butter(){
        setImage(butterShot);
    }
    public void setRotationOfButter(int rotation)
    {
           super.setRotation(rotation);        
    }
    public void act() 
    {
      move(1);       
    }    
}

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
        setPaintOrder(SyrupHealth.class, whitebar.class);
        setBackground(new GreenfootImage("Background.jpg"));
        waffle waffle = new waffle();
        
        for (int i = 0; i < 10;i++){
            SyrupHealth syrup = new SyrupHealth();
            addObject(syrup, 50 + (20*i), 10);
            waffle.addHealthBottle(syrup);
        }
        pancake pancake = new pancake();
        for (int i = 0; i < 10;i++){
            SyrupHealth syrup = new SyrupHealth();
            addObject(syrup, 750 - (20*i), 10);
            pancake.addHealthBottle(syrup);
        }
        addObject(waffle, 200, 200);
        addObject(pancake, 400, 400);
        addObject(new whitebar(), 400, 10);
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

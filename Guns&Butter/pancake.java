import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class pancake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pancake extends Actor
{

    private int health = 10;
    public int shotCounterPancake = 29;
    public int shotCounterMaxPancake = 30;
    private int butterPowerUpCounter = 0;
    private int maxHealth = 10;
    public ArrayList<SyrupHealth> healthBar = new ArrayList<SyrupHealth>();
    /**
     * Act - do whatever the pancake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        lookForButter();
        movement();
        shoot();
        butterPowerUp();
        healthUp();
        checkifDed();
        
        
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void movement(){
        if (Greenfoot.isKeyDown("right")) {
            
            this.turn(3);
        }
        if (Greenfoot.isKeyDown("left")) {
            this.turn(-3);
        }
        if (Greenfoot.isKeyDown("down")) {
            if(this.getY() <= 90){
                this.setLocation(this.getX(),90);
            } 
            if(this.getY() >= 790){
                this.setLocation(this.getX(),790);
            }
            if(this.getX() >= 790){
                this.setLocation(790,this.getY());
            } 
            if(this.getX() <= 10){
                this.setLocation(10,this.getY());
            } 
            this.move(-2);
        }
        if (Greenfoot.isKeyDown("up")) {
            if(this.getY() <= 90){
                this.setLocation(this.getX(),90);
            } 
            if(this.getY() >= 790){
                this.setLocation(this.getX(),790);
            }
            if(this.getX() >= 790){
                this.setLocation(790,this.getY());
            } 
            if(this.getX() <= 10){
                this.setLocation(10,this.getY());
            } 
            this.move(2);
        }
    }
    public void checkifDed() {
        if (this.health == 0) {
            this.getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }

    public void shoot(){
       if (Greenfoot.isKeyDown("m")) {
            shotCounterPancake++;
            if (shotCounterPancake >= shotCounterMaxPancake){
                Butter butter = new Butter();
                butter.setRotationOfButter(this.getRotation());
                butter.setOwner(1);
                getWorld().addObject(butter, this.getX(), this.getY());
                shotCounterPancake = 0;
            }
       }
    }
    
    public void butterPowerUp(){
        butterPowerUp b = (butterPowerUp) getOneIntersectingObject(butterPowerUp.class);
        if (b != null){
            getWorld().removeObject(b);
            shotCounterMaxPancake = 15;
            butterPowerUpCounter = 200;
        }
        if (butterPowerUpCounter != 0){
            butterPowerUpCounter--; 
        }
        if (butterPowerUpCounter == 0){
           shotCounterMaxPancake = 30; 
        }
    }
    
    public void lookForButter(){
        if (isTouching(Butter.class)){
            Butter a = (Butter) getOneIntersectingObject(Butter.class);
            if (a.getOwner() == 0){

                health -= 1;
                getWorld().removeObject(healthBar.get(healthBar.size() - 1));
                healthBar.remove(healthBar.size() - 1);
                this.getWorld().removeObject(a);
            }
        }
    }
    
    public void healthUp(){
        healthUp b = (healthUp) getOneIntersectingObject(healthUp.class);
        if (b != null){
            getWorld().removeObject(b);
            if (health < maxHealth){
                
                int haveHealth = healthBar.size();
                SyrupHealth syrup = new SyrupHealth();
                getWorld().addObject(syrup, 750 - (20* (haveHealth)), 10);
                this.addHealthBottle(syrup);
                health+=1;
            }
        }
    }
    
    public void addHealthBottle(SyrupHealth syrup){
        healthBar.add(syrup);
    }
}

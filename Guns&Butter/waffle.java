
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;


/**
 * Write a description of class waffle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class waffle extends Actor {

    private int health = 10;
    public int shotCounterWaffle = 29;
    public int shotCounterMaxWaffle = 30;
    private int butterPowerUpCounter = 0;
    private int maxHealth = 10;
    public ArrayList<SyrupHealth> healthBar = new ArrayList<SyrupHealth>();
    /**
     * Act - do whatever the waffle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
        
        lookForButter();
        movement();
        shoot();
        butterPowerUp();
        healthUp();
        checkifDed();
        
        
    }
    
    public void addHealthBottle(SyrupHealth syrup){
        healthBar.add(syrup);
    }
    public void checkifDed() {
        if (this.health == 0) {
            this.getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void movement(){
        if (Greenfoot.isKeyDown("d")) {
            this.turn(3);
        }
        if (Greenfoot.isKeyDown("a")) {
            this.turn(-3);
        }
        if (Greenfoot.isKeyDown("s")) {
            this.move(-2);
        }
        if (Greenfoot.isKeyDown("w")) {
            if(this.getY() <= 100){
                this.setLocation(this.getX(),100);
            } 
            this.move(2);
        }
    }
    
    public void shoot() {
       if (Greenfoot.isKeyDown("space")) {
            shotCounterWaffle++;
            if (shotCounterWaffle >= shotCounterMaxWaffle){
                Butter butter = new Butter();
                butter.setRotationOfButter(this.getRotation());
                butter.setOwner(0);
                getWorld().addObject(butter, this.getX(), this.getY());
                shotCounterWaffle = 0;
            }
       }
    }
        

    
    public void butterPowerUp(){
        butterPowerUp b = (butterPowerUp) getOneIntersectingObject(butterPowerUp.class);
        if (b != null){
            getWorld().removeObject(b);
            shotCounterMaxWaffle = 15;
            butterPowerUpCounter = 200;
        }
        if (butterPowerUpCounter != 0){
            butterPowerUpCounter--; 
        }
        if (butterPowerUpCounter == 0){
           shotCounterMaxWaffle = 30; 
        }
    }
    
    public void lookForButter(){
        if (isTouching(Butter.class)){

            Butter a = (Butter) getOneIntersectingObject(Butter.class);
            if (a.getOwner() == 1){
                health = health - 1;
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
                getWorld().addObject(syrup, 50 + (20* (haveHealth)), 10);
                this.addHealthBottle(syrup);
                health+=1;
            }
            
        }
    }
}   
    

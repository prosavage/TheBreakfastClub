import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pancake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pancake extends Actor
{

    private int health = 200;
    public int shotCounterPancake = 29;
    public int shotCounterMaxPancake = 30;
    private int butterPowerUpCounter = 0;
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
            this.move(-2);
        }
        if (Greenfoot.isKeyDown("up")) {
            this.move(2);
        }
    }
    
    public void shoot(){
       if (Greenfoot.isKeyDown("m")) {
            shotCounterPancake++;
            if (shotCounterPancake >= shotCounterMaxPancake){
                Butter butter = new Butter();
                butter.setRotationOfButter(this.getRotation());
                getWorld().addObject(butter, this.getX(), this.getY());
                shotCounterPancake = 0;
            }
        }
        if (isTouching(Butter.class)){
           Butter c = (Butter) getOneIntersectingObject(Butter.class);
           c.owner = 1;
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
        if(isTouching(Butter.class)){
            Butter a = (Butter) getOneIntersectingObject(Butter.class);
            if (a.owner == 0){
                health = health - 20;
                getWorld().removeObject(a);
            }
        }
    }
}

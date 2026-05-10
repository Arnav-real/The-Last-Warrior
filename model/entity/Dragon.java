package model.entity;
import java.util.*;


public class Dragon extends Enemy{
    private int turnCounter = 0;

    public Dragon(){
        super("Dragon", 200, 200, 50, 20, 60, 80);
    }

    public void attack(Entity target){
        target.takeDamage(atk);
    }

    public void specialAction(Warrior warrior, List<Enemy> allies) {
        turnCounter++;
        if(turnCounter%3 == 0) {
            warrior.takeDamage((int)(atk*1.5));
        } 
    }

    public String toString() {
        return "🐉 " + super.toString();
    }
}

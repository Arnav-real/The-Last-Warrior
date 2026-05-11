package model.entity;
import java.util.*;

public class Goblin extends Enemy{
    
    public Goblin() {
        super("Goblin", 25, 25, 6, 0, 5, 10);
    }

    public void attack(Entity target){
        target.takeDamage(atk);
        target.takeDamage(atk);
    }

    public void specialAction(Warrior warrior, List<Enemy> allies) {
        
    }

    public String toString() {
        return "👺 " + super.toString();
    }

}


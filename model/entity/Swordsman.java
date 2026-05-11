package model.entity;
import java.util.*;

public class Swordsman extends Enemy{
    
    public Swordsman() {
        super("Swordsman", 50, 50, 12, 5, 10, 15);
    }

    public void attack(Entity target){
        target.takeDamage(atk);
    }

    public void specialAction(Warrior warrior, List<Enemy> allies) {
        attack(warrior);
    }

    public String toString() {
        return "⚔️ " + super.toString();
    }

}
package model.entity;

import java.util.List;

public class Archer extends Enemy {
    public Archer() {
        super("Archer", 50, 50, 20, 0, 12, 15);
    }

    public void attack(Entity target){
        target.takeDamage(atk);
    }

    public void specialAction(Warrior warrior, List<Enemy> allies) {
        if(Math.random() < 0.3) {
            warrior.takeDamageIgnoreDefense(atk);
        }
    }

    public String toString() {
        return "🏹 " + super.toString();
    }
}

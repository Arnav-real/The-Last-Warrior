package model.entity;

import java.util.List;

public class Wizard extends Enemy{
    public Wizard() {
        super("Wizard", 70, 70, 35, 0, 25, 30);
    }

    public void attack(Entity target){
        target.takeDamage(atk);
    }

    public void specialAction(Warrior warrior, List<Enemy> allies) {
        for(Enemy ally : allies) {
            if(ally.isAlive()) ally.hp = Math.min(ally.maxHp, ally.hp + 20);
        }
        attack(warrior);
    }

    public String toString() {
        return "🧙 " + super.toString();
    }
}

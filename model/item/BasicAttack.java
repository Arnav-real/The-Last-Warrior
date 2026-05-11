package model.item;

import java.util.List;

import model.entity.Enemy;
import model.entity.Warrior;

public class BasicAttack extends Ability{
    public BasicAttack() {
        super(0);
    }

    public void effect(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        targetEnemy.takeDamage(warrior.getAtk());
    }    
}

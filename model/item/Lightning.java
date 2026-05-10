package model.item;

import java.util.*;
import model.entity.*;

public class Lightning extends Ability{
    
    Lightning() {
        super(30);
    }

    public void effect(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        for(Enemy enemy : enemies) {
            if(Math.random() > 0.5) {
                enemy.takeDamage(45);
            }
        }

        if(Math.random() < 0.4) {
            for(Enemy enemy : enemies) {
                enemy.setStunned(true);
            }
        }
    }
}

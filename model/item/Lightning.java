package model.item;

import java.util.*;
import model.entity.*;

public class Lightning extends Ability{
    
    public Lightning() {
        super(30);
    }

    public void effect(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        for(Enemy enemy : enemies) {
            if(Math.random() > 0.5) {
                enemy.takeDamage(60);
                if(Math.random() < 0.4) {
                    enemy.setStunned(true);
                }
            }
        }
    }
}

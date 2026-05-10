package model.item;

import java.util.*;
import model.entity.*;

public class Fireball extends Ability {
    
    Fireball() {
        super(20);
    }

    public void effect(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        for(Enemy enemy : enemies) {
            enemy.takeDamage(30);
        }
    }

}

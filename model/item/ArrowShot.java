package model.item;

import java.util.*;
import model.entity.*;

public class ArrowShot extends Ability{
    
    public ArrowShot() {
        super(10);
    }

    public void effect(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        targetEnemy.takeDamageIgnoreDefense(45);
    }

}

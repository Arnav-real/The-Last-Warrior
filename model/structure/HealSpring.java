package model.structure;

import java.util.List;

import model.entity.Enemy;
import model.entity.Warrior;

public class HealSpring implements Structures{
    public int getCost() {
        return 150;
    }

    public String getDescription() {
        return "A sacred spring hidden deep within the fortress walls. Its waters mend your wounds after every battle.";
    }

    public void activate(List<Enemy> enemies, Warrior warrior) {
        warrior.setHealingSpringActive(true);
    }
}

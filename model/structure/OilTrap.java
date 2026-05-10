package model.structure;

import java.util.List;

import model.entity.Enemy;
import model.entity.Warrior;

public class OilTrap implements Structures{
    public int getCost() {
        return 80;
    }

    public String getDescription() {
        return "Barrels of flaming oil rigged at the fortress gate.\n Douses all enemies in fire before they reach you, weakening the horde.";
    }

    public void activate(List<Enemy> enemies, Warrior warrior) {
        warrior.setOilTrapActive(true);
    }
}

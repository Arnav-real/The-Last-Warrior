package model.structure;

import java.util.List;

import model.entity.Enemy;
import model.entity.Warrior;

public class MagicSeal implements Structures{
    public int getCost() {
        return 120;
    }

    public String getDescription() {
        return "An ancient ward carved into the fortress stone by a long dead mage.\n Pulses with energy, occasionally deflecting enemy strikes.";
    }

    public void activate(List<Enemy> enemies, Warrior warrior) {
        warrior.setMagicSealActive(true);
    }
}

package model.structure;

import java.util.List;

import model.entity.Enemy;
import model.entity.Warrior;

public class Ballista implements Structures{
    public int getCost() {
        return 100;
    }

    public String getDescription() {
        return "A massive siege weapon mounted on the fortress wall.\nFires a steel bolt at the strongest enemy before battle begins.";
    }

    public void activate(List<Enemy> enemies, Warrior warrior) {
        warrior.setBallistaActive(true);
    }
}

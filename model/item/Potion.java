package model.item;

import model.entity.Warrior;

public class Potion extends Item {
    public Potion() {
        super("Potion", "Restores 50 HP", 50);
    }

    @Override
    public void use(Warrior warrior) {
        warrior.setHp(Math.min(warrior.getMaxHp(), warrior.getHp() + 50));
    }
}
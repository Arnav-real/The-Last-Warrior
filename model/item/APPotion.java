package model.item;

import model.entity.Warrior;

public class APPotion extends Item {
    public APPotion() {
        super("AP Potion", "Restores 40 Arcane Points", 40);
    }

    @Override
    public void use(Warrior warrior) {
        warrior.setAp(Math.min(warrior.getMaxAp(), warrior.getAp() + 40));
    }
}
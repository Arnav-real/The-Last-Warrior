package model.item;

import model.entity.Warrior;

public class WeaponScroll extends Item {
    public WeaponScroll() {
        super("Weapon Scroll", "Permanently increases ATK by 10", 80);
    }

    @Override
    public void use(Warrior warrior) {
        warrior.setAtk(warrior.getAtk() + 10);
    }
}
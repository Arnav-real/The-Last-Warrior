package model.item;

import java.util.*;
import model.entity.*;

public abstract class Ability {
    protected int ap_cost;

    Ability(int ap_cost) {
        this.ap_cost = ap_cost;
    }

    public abstract void effect(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy);

}

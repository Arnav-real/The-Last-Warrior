package strategy;

import model.entity.*;
import java.util.*;

public class BerserkerRage implements PowerUp{


    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setAtk((int)(warrior.getAtk()*1.5));
    }
}

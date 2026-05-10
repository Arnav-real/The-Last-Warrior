package strategy;

import java.util.*;
import model.entity.*;

public class LastStand implements PowerUp{
    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setlastStandActive(true);
    }
}

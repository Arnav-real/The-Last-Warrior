package strategy;

import java.util.*;
import model.entity.*;

public class DeathBargain implements PowerUp{
    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setDeathBargainActive(true);
    }
}

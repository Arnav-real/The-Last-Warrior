package strategy;

import model.entity.*;
import java.util.*;

public class VampireStrike implements PowerUp{
    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setVampireStrikeActive(true);
    }
}

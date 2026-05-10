package strategy;

import java.util.*;
import model.entity.*;

public class ThunderClap implements PowerUp{
    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setThunderClapActive(true);
    }
}

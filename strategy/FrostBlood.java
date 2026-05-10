package strategy;

import model.entity.*;
import java.util.*;


public class FrostBlood implements PowerUp{
    
    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setFrostBloodActive(true);
    }
}

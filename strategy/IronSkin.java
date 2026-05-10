package strategy;

import model.entity.*;
import java.util.*;

public class IronSkin implements PowerUp{
    
    public void powerUpEffect(List<Enemy> enemies, Warrior warrior) {
        warrior.setDef(warrior.getDef() + 10);
    }
}

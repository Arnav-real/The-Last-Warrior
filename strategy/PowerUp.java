package strategy;

import model.entity.*;
import java.util.*;

public interface PowerUp {
    
    void powerUpEffect(List<Enemy> enemies, Warrior warrior);

}

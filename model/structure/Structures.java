package model.structure;

import model.entity.*;
import java.util.*;

public interface Structures {
    public int getCost();

    public void activate(List<Enemy> enemies, Warrior warrior);

    public String getDescription();
} 

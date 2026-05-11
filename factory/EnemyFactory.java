package factory;

import model.entity.*;
import java.util.*;;


public class EnemyFactory {
    

    public static List<Enemy> createWave(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();

        int goblinCount = waveNumber*2;

        for(int i = 0; i < goblinCount; i++) {
            enemies.add(new Goblin());
        }

        if(waveNumber >= 3) {
            enemies.add(new Swordsman());
        }

        if(waveNumber >= 5) {
            enemies.add(new Archer());
        }

        if(waveNumber >= 8) {
            enemies.add(new Giant());
        }

        if(waveNumber >= 12) {
            enemies.add(new Wizard());
        }

        if(waveNumber >= 15) {
            enemies.add(new Dragon());
        }

        return enemies;
    }
}

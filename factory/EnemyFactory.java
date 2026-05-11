package factory;

import model.entity.*;
import java.util.*;;


public class EnemyFactory {
    

    public static List<Enemy> createWave(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();

        int goblinCount = waveNumber*2;

        for(int i = 0; i < goblinCount; i++) {
            Goblin g = new Goblin();
            g.scaleToWave(waveNumber);
            enemies.add(g);
        }

        if(waveNumber >= 3) {
            Swordsman swordsman = new Swordsman();
            swordsman.scaleToWave(waveNumber);
            enemies.add(swordsman);
        }

        if(waveNumber >= 5) {
            Archer archer = new Archer();
            archer.scaleToWave(waveNumber);
            enemies.add(archer);
        }

        if(waveNumber >= 8) {
            Giant giant = new Giant();
            giant.scaleToWave(waveNumber);   
            enemies.add(giant);
        }

        if(waveNumber >= 12) {
            Wizard wizard = new Wizard();
            wizard.scaleToWave(waveNumber);
            enemies.add(wizard);
        }

        if(waveNumber >= 15) {
            Dragon dragon = new Dragon();
            dragon.scaleToWave(waveNumber);
            enemies.add(dragon);
        }

        return enemies;
    }
}

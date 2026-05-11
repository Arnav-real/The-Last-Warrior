package factory;

import model.entity.*;
import java.util.List;

public class WaveComposer {
    public List<Enemy> buildWave(int waveNumber) {
        return EnemyFactory.createWave(waveNumber);
    }
}

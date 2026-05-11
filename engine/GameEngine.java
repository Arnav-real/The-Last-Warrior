package engine;

import java.util.List;
import java.util.Scanner;

import factory.WaveComposer;
import model.entity.Enemy;
import model.entity.Warrior;
import ui.CLIPrinter;

public class GameEngine {
    private static GameEngine instance;

    private GameEngine() {};

    public static GameEngine getInstance() {
        if(instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    Scanner sc = new Scanner(System.in);
    private int currentWave = 1;
    private BattleEngine battleEngine = new BattleEngine();

    public void start() {
        CLIPrinter.printWelcome();
        CLIPrinter.printAskName();
        String name = sc.nextLine();
        Warrior warrior = new Warrior(name);

        WaveComposer waveComposer = new WaveComposer();

        while(true) {
            List<Enemy> enemies = waveComposer.buildWave(currentWave);
            battleEngine.startWave(currentWave, warrior, enemies);
            
            if(!warrior.isAlive()) break;

            currentWave++;
            CLIPrinter.printPressEnter();
            sc.nextLine();
        }

        CLIPrinter.printDeath();
    }
} 



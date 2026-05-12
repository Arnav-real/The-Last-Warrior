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
        System.out.print(CLIPrinter.CYAN + "  New player? Read instructions? [y/n]: " + CLIPrinter.RESET);
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")) {
            CLIPrinter.printInstructions(sc);
        }
        CLIPrinter.printAskName();
        String name = sc.nextLine();
        Warrior warrior = new Warrior(name);

        WaveComposer waveComposer = new WaveComposer();

        while(true) {
            List<Enemy> enemies = waveComposer.buildWave(currentWave);
            battleEngine.startWave(currentWave, warrior, enemies);

            
            if(warrior.getXp() >= warrior.getLevel() * 100) {
                warrior.levelUp();
                CLIPrinter.printMessage("  ⚔ LEVEL UP! You are now Level " + warrior.getLevel() + "!", CLIPrinter.YELLOW);
                CLIPrinter.printMessage("  HP, AP, ATK and DEF increased!", CLIPrinter.GREEN);
            }

            if(!warrior.isAlive()) break;

            currentWave++;
            for(Enemy enemy : enemies) {
                enemy.scaleToWave(currentWave);
            }
            CLIPrinter.printPressEnter();
            sc.nextLine();
        }

        CLIPrinter.printDeath();
        System.out.println(CLIPrinter.CYAN +   "  Waves survived: " + currentWave + CLIPrinter.RESET);
        CLIPrinter.printSeparator();
    }
} 



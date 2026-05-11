package engine;

import model.entity.*;
import ui.CLIPrinter;
import java.util.*;

public class BattleEngine {
    public void startWave(int waveNumber, Warrior warrior, List<Enemy> enemies) {
        CLIPrinter.printWaveStart(waveNumber);

        while(warrior.isAlive() && isWaveOver(enemies)) {
            CLIPrinter.clearScreen();
            CLIPrinter.printWarriorStats(warrior);
            CLIPrinter.printEnemyList(enemies);
            playerTurn(enemies, warrior);
            if (warrior.isAlive()) {
                
            }
        }
    }

    public void playerTurn(List<Enemy> enemies, Warrior warrior) {
        Scanner sc = new Scanner(System.in);

        CLIPrinter.printCombatMenu();
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice > 4 || choice < 1) {
            System.out.println("Invalid Choice, turn skipped");
        }        
        
        
    }

    public boolean isWaveOver(List<Enemy> enemies) {
        for(Enemy enemy : enemies) {
            if (enemy.isAlive()) return false;
        }
        return true;
    }


    public void handleBasicAttack(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        targetEnemy.takeDamage(warrior.getAtk());
    }

    public void handleFireball(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        if(warrior.getAp() >= 20) {
            warrior.setAp(warrior.getAp() - 20);
        }
        else {
            System.out.println("Insufficient Arcane Points!");
        }
        
        for(Enemy enemy : enemies) {
            enemy.takeDamage(30);
        }
    }

    public void handleLightning(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        if(warrior.getAp() >= 30) {
            warrior.setAp(warrior.getAp() - 30);
        }
        else {
            System.out.println("Insufficient Arcane Points!");
        }

        for(Enemy enemy : enemies) {
            if(Math.random() < 0.5) {
                enemy.takeDamage(60);
            }
        }
    }

    public void Arrowshot(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        if(warrior.getAp() >= 10) {
            warrior.setAp(warrior.getAp() - 10);
        }
        else {
            System.out.println("Insufficient Arcane Points!");
        }

        targetEnemy.takeDamageIgnoreDefense(45);
    }
}


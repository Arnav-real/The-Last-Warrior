package engine;

import model.entity.*;
import ui.CLIPrinter;
import java.util.*;

public class BattleEngine {
    private Scanner sc = new Scanner(System.in);
    public void startWave(int waveNumber, Warrior warrior, List<Enemy> enemies) {
        CLIPrinter.printWaveStart(waveNumber);

        while(warrior.isAlive() && !isWaveOver(enemies)) {
            CLIPrinter.clearScreen();
            CLIPrinter.printWarriorStats(warrior);
            CLIPrinter.printEnemyList(enemies);
            playerTurn(enemies, warrior);
            if (warrior.isAlive()) {
                enemyTurn(enemies, warrior);
            }
        }
        if(warrior.isAlive()) {
            CLIPrinter.printVictory();
        } 
    }

    public void playerTurn(List<Enemy> enemies, Warrior warrior) {

        CLIPrinter.printCombatMenu();
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice > 4 || choice < 1) {
            System.out.println("Invalid Choice, turn skipped");
        }
        
        switch (choice) {
            case 1:
                Enemy basicTargetEnemy = pickTarget(enemies);
                handleBasicAttack(enemies, warrior, basicTargetEnemy);
                break;
            
            case 2:
                handleFireball(enemies, warrior, null);
                break;

            case 3:
                Enemy arrowTargetEnemy = pickTarget(enemies);
                handleArrowshot(enemies, warrior, arrowTargetEnemy);
                break;

            case 4:
                handleLightning(enemies, warrior, null);
                break;

            default:
                break;
        }
    }

    public void enemyTurn(List<Enemy> enemies, Warrior warrior) {
        for(Enemy enemy : enemies) {
            if(enemy.isAlive()) {
                if(enemy.isStunned()) {
                    enemy.setStunned(false);
                    CLIPrinter.printMessage("  " + enemy.getName() + " is stunned and skips their turn!", CLIPrinter.YELLOW);
                } else {
                    enemy.attack(warrior);
                    enemy.specialAction(warrior, enemies);
                }
            }
        }
    }

    public boolean isWaveOver(List<Enemy> enemies) {
        for(Enemy enemy : enemies) {
            if (enemy.isAlive()) return false;
        }
        return true;
    }


    public Enemy pickTarget(List<Enemy> enemies) {
        CLIPrinter.printMessage("Pick a target", CLIPrinter.YELLOW);
        int i = 1;
        for(Enemy enemy : enemies) {
            if(enemy.isAlive()) {
                System.out.println("  [" + i + "] " + enemy);
            }
            i++;
        }
        int choice = sc.nextInt() - 1;
        return enemies.get(choice);
    }

    public void handleBasicAttack(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        targetEnemy.takeDamageIgnoreDefense(45);
        CLIPrinter.printMessage("  You dealt 45 damage to " + targetEnemy.getName() + "!", CLIPrinter.GREEN);
        if(!targetEnemy.isAlive()) {
            warrior.setGold(warrior.getGold() + targetEnemy.get_gold());
            warrior.setXp(warrior.getXp() + targetEnemy.get_xp());
            CLIPrinter.printMessage("  " + targetEnemy.getName() + " defeated! +" + targetEnemy.get_gold() + " gold  +" + targetEnemy.get_xp() + " XP", CLIPrinter.YELLOW);
        }
    }
        
    public void handleFireball(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        if(warrior.getAp() >= 20) {
            warrior.setAp(warrior.getAp() - 20);
            for(Enemy enemy : enemies) {
                enemy.takeDamage(30);
                if(!enemy.isAlive()) {
                    warrior.setGold(warrior.getGold() + enemy.get_gold());
                    warrior.setXp(warrior.getXp() + enemy.get_xp());
                    CLIPrinter.printMessage("  " + enemy.getName() + " defeated! +" + enemy.get_gold() + " gold  +" + enemy.get_xp() + " XP", CLIPrinter.YELLOW);
                }
            }
            CLIPrinter.printMessage("  Fireball hits all enemies for 30 damage!", CLIPrinter.RED);
        }else {
            CLIPrinter.printMessage("Insufficient Arcane Points!", CLIPrinter.RED);
        }
        
        
    }

    public void handleLightning(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        if(warrior.getAp() >= 30) {
            warrior.setAp(warrior.getAp() - 30);
            for(Enemy enemy : enemies) {
                if(Math.random() < 0.5) {
                    enemy.takeDamage(60);
                }
                if(!enemy.isAlive()) {
                    warrior.setGold(warrior.getGold() + enemy.get_gold());
                    warrior.setXp(warrior.getXp() + enemy.get_xp());
                    CLIPrinter.printMessage("  " + enemy.getName() + " defeated! +" + enemy.get_gold() + " gold  +" + enemy.get_xp() + " XP", CLIPrinter.YELLOW);
                }
            }
            CLIPrinter.printMessage("  Lightning strikes random enemies for 60 damage!", CLIPrinter.YELLOW);

        }
        else {
            CLIPrinter.printMessage("Insufficient Arcane Points!", CLIPrinter.RED);
        }

        
    }

    public void handleArrowshot(List<Enemy> enemies, Warrior warrior, Enemy targetEnemy) {
        if(warrior.getAp() >= 10) {
            warrior.setAp(warrior.getAp() - 10);
            targetEnemy.takeDamageIgnoreDefense(45);

            if(!targetEnemy.isAlive()) {
                warrior.setGold(warrior.getGold() + targetEnemy.get_gold());
                warrior.setXp(warrior.getXp() + targetEnemy.get_xp());
                CLIPrinter.printMessage("  " + targetEnemy.getName() + " defeated! +" + targetEnemy.get_gold() + " gold  +" + targetEnemy.get_xp() + " XP", CLIPrinter.YELLOW);
            }

            CLIPrinter.printMessage("  You dealt " + warrior.getAtk() + " damage to " + targetEnemy.getName() + "!", CLIPrinter.GREEN);
        }
        else {
            System.out.println("Insufficient Arcane Points!");
        }
    }
}


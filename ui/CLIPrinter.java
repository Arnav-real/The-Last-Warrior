package ui;

import model.entity.*;
import java.util.*;

public class CLIPrinter {
    
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN   = "\u001B[36m";
    public static final String RESET  = "\u001B[0m";
    public static final String WHITE = "\u001B[37m";

    public static void printSeparator() {
        System.out.println(CYAN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
    }

    public static void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void printMessage(String message, String color) {
        System.out.println(color + message + RESET);
    }

    public static void printWarriorStats(Warrior warrior) {
        printSeparator();
        System.out.println(YELLOW + "  ⚔  " + warrior.getName() +
                "  |  Level " + warrior.getLevel() +
                "  |  Gold: " + warrior.getGold() + " 🪙" + RESET);
        printSeparator();

        // HP bar
        int hpFilled = (warrior.getHp() * 20) / warrior.getMaxHp();
        int hpEmpty  = 20 - hpFilled;
        String hpColor = warrior.getHp() > warrior.getMaxHp() / 2 ? GREEN :
                        warrior.getHp() > warrior.getMaxHp() / 4 ? YELLOW : RED;
        System.out.print("  HP  " + hpColor);
        for (int i = 0; i < hpFilled; i++) System.out.print("█");
        for (int i = 0; i < hpEmpty; i++)  System.out.print("░");
        System.out.println(RESET + "  " + warrior.getHp() + "/" + warrior.getMaxHp());

        // AP bar
        int apFilled = (warrior.getAp() * 20) / warrior.getMaxAp();
        int apEmpty  = 20 - apFilled;
        System.out.print("  AP  " + BLUE);
        for (int i = 0; i < apFilled; i++) System.out.print("█");
        for (int i = 0; i < apEmpty; i++)  System.out.print("░");
        System.out.println(RESET + "  " + warrior.getAp() + "/" + warrior.getMaxAp());

        printSeparator();
        {}
    }

    public static void printEnemyList(List<Enemy> enemies) { 
        printSeparator();
        System.out.println(RED + "  [ ENEMIES ]" + RESET);
        printSeparator();

        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                int hpFilled = (enemy.getHp() * 20) / enemy.getMaxHp();
                int hpEmpty  = 20 - hpFilled;
                System.out.print("  " + enemy.toString() + "  ");
                System.out.print(RED);
                for (int i = 0; i < hpFilled; i++) System.out.print("█");
                for (int i = 0; i < hpEmpty; i++)  System.out.print("░");
                System.out.println(RESET + "  " + enemy.getHp() + "/" + enemy.getMaxHp());
            }
        }
        printSeparator();
    }

    public static void printCombatMenu() {
        printSeparator();
        System.out.println(YELLOW + "  [ YOUR TURN ]" + RESET);
        printSeparator();
        System.out.println("  [1] " + WHITE + "Basic Attack  " + RESET + "  (Free)");
        System.out.println("  [2] " + PURPLE + "Fireball      " + RESET + "  (20 AP) — hits all enemies");
        System.out.println("  [3] " + BLUE + "Arrow Shot    " + RESET + "  (10 AP) — bypasses armor");
        System.out.println("  [4] " + YELLOW + "Lightning     " + RESET + "  (30 AP) — stuns 40% chance");
        printSeparator();
        System.out.print(GREEN + "  > " + RESET);   
    }

    public static void printWaveStart(int waveNumber) {
        clearScreen();
        printSeparator();
        System.out.println(YELLOW + "  ⚔  WAVE " + waveNumber + " INCOMING!" + RESET);
        System.out.println(RED + "  Prepare yourself, warrior..." + RESET);
        printSeparator();
    }

    public static void printVictory() {
        printSeparator();
        System.out.println(GREEN + "  ✔  WAVE CLEARED!" + RESET);
        System.out.println(YELLOW + "  The enemies have fallen. Rest while you can..." + RESET);
        printSeparator();
    }

    public static void printDeath() {
        clearScreen();
        printSeparator();
        System.out.println(RED + "  ██████  ███████  ███████  ██████  " + RESET);
        System.out.println(RED + "  ██  ██  ██       ██   ██  ██  ██  " + RESET);
        System.out.println(RED + "  ██  ██  █████    ███████  ██  ██  " + RESET);
        System.out.println(RED + "  ██  ██  ██       ██   ██  ██  ██  " + RESET);
        System.out.println(RED + "  ██████  ███████  ██   ██  ██████  " + RESET);
        printSeparator();
        System.out.println(YELLOW + "  The fortress has fallen. You fought bravely." + RESET);
        printSeparator();
    }


}

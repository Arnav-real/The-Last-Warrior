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
        for (int i = 0; i < 5; i++) System.out.println();
    }

    public static void printMessage(String message, String color) {
        System.out.println(color + message + RESET);
    }

    public static void printInstructions(Scanner sc) {
        clearScreen();
        printSeparator();
        System.out.println(YELLOW + "  📖  HOW TO PLAY — LAST WARRIOR" + RESET);
        printSeparator();
        System.out.println(CYAN + "  You are the last guardian of an ancient fortress." + RESET);
        System.out.println(CYAN + "  Endless waves of enemies attack each night." + RESET);
        System.out.println(CYAN + "  Survive as long as you can." + RESET);
        printSeparator();
        System.out.println(GREEN + "  Press ENTER to continue..." + RESET);
        sc.nextLine();

        clearScreen();
        printSeparator();
        System.out.println(YELLOW + "  ⚔  COMBAT" + RESET);
        printSeparator();
        System.out.println(WHITE + "  Each turn YOU attack first, then enemies attack." + RESET);
        System.out.println(WHITE + "  Pick a target when asked, or abilities hit all enemies." + RESET);
        System.out.println(WHITE + "  If your HP reaches 0 — the fortress falls." + RESET);
        printSeparator();
        System.out.println(YELLOW + "  YOUR ABILITIES:" + RESET);
        System.out.println("  [1] " + WHITE + "Basic Attack  " + RESET + "— Free. Hits one enemy for your ATK damage.");
        System.out.println("  [2] " + PURPLE + "Fireball      " + RESET + "— 20 AP. Engulfs ALL enemies in flames for 30 damage.");
        System.out.println("  [3] " + BLUE + "Arrow Shot    " + RESET + "— 10 AP. Pierces one enemy for 45 damage, ignores armor.");
        System.out.println("  [4] " + YELLOW + "Lightning     " + RESET + "— 30 AP. Strikes random enemies for 60 damage + 40% stun.");
        printSeparator();
        System.out.println(GREEN + "  Press ENTER to continue..." + RESET);
        sc.nextLine();

        clearScreen();
        printSeparator();
        System.out.println(YELLOW + "  👹  ENEMIES" + RESET);
        printSeparator();
        System.out.println("  👺 " + RED + "Goblin     " + RESET + "— Weak but attacks TWICE per turn. Comes in large groups.");
        System.out.println("  ⚔  " + RED + "Swordsman  " + RESET + "— Balanced fighter. Nothing special, but hits hard.");
        System.out.println("  🏹 " + RED + "Archer     " + RESET + "— 30% chance to BYPASS your armor completely.");
        System.out.println("  🗿 " + RED + "Giant      " + RESET + "— Massive HP and ATK. Skips every 3rd turn (slow).");
        System.out.println("  🧙 " + RED + "Wizard     " + RESET + "— HEALS allies each turn. Kill him first!");
        System.out.println("  🐉 " + RED + "Dragon     " + RESET + "— BOSS. Every 3rd turn unleashes Fire Breath for 1.5x damage.");
        printSeparator();
        System.out.println(CYAN + "  TIP: Kill Wizards first — they heal other enemies!" + RESET);
        System.out.println(CYAN + "  TIP: Use Fireball on large groups, Arrow Shot on Wizards." + RESET);
        printSeparator();
        System.out.println(GREEN + "  Press ENTER to continue..." + RESET);
        sc.nextLine();

        clearScreen();
        printSeparator();
        System.out.println(YELLOW + "  📈  PROGRESSION" + RESET);
        printSeparator();
        System.out.println(WHITE + "  ⭐ Kill enemies to earn " + YELLOW + "GOLD" + WHITE + " and " + CYAN + "XP" + RESET);
        System.out.println(WHITE + "  ⭐ Earn enough XP to " + GREEN + "LEVEL UP" + WHITE + " — boosts all your stats" + RESET);
        System.out.println(WHITE + "  ⭐ Every 3 waves choose a " + PURPLE + "POWER-UP" + WHITE + " to enhance your warrior" + RESET);
        System.out.println(WHITE + "  ⭐ Spend gold in the " + YELLOW + "SHOP" + WHITE + " between waves" + RESET);
        printSeparator();
        System.out.println(YELLOW + "  WAVE UNLOCKS:" + RESET);
        System.out.println("  Wave  1  → " + RED + "Goblins" + RESET);
        System.out.println("  Wave  3  → " + RED + "Swordsmen" + RESET);
        System.out.println("  Wave  5  → " + RED + "Archers" + RESET);
        System.out.println("  Wave  8  → " + RED + "Giants" + RESET);
        System.out.println("  Wave 12  → " + RED + "Wizards" + RESET);
        System.out.println("  Wave 15  → " + RED + "Dragon 🐉" + RESET);
        printSeparator();
        System.out.println(GREEN + "  Press ENTER to begin your journey..." + RESET);
        sc.nextLine();
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
        System.out.println("  [1] " + WHITE + "Basic Attack  " + RESET + " (Free)   — Strike one enemy for " + YELLOW + "ATK damage" + RESET);
        System.out.println("  [2] " + PURPLE + "Fireball      " + RESET + " (20 AP)  — Engulf ALL enemies in flames for " + RED + "30 damage" + RESET);
        System.out.println("  [3] " + BLUE + "Arrow Shot    " + RESET + " (10 AP)  — Pierce one enemy for " + CYAN + "45 damage, ignores armor" + RESET);
        System.out.println("  [4] " + YELLOW + "Lightning     " + RESET + " (30 AP)  — Strike random enemies for " + YELLOW + "60 damage + 40% stun" + RESET);
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

    public static void printAskName() {
        printSeparator();
        System.out.println(YELLOW + "  ⚔  WELCOME, WARRIOR  ⚔" + RESET);
        printSeparator();
        System.out.println(CYAN + "  The fortress stands on the edge of darkness." + RESET);
        System.out.println(CYAN + "  One warrior remains. That warrior is you."    + RESET);
        System.out.println(CYAN + "  Your name will be remembered... or forgotten." + RESET);
        printSeparator();
        System.out.print(GREEN + "  Enter your name, warrior: " + RESET);
    }

    public static void printPressEnter() {
        printSeparator();
        System.out.println(CYAN + "  ⚔  Wave cleared! Rest while you can..." + RESET);
        System.out.println(GREEN + "  Press ENTER to face the next wave..." + RESET);
        printSeparator();
    }

    public static void printWelcome() {
        clearScreen();
        printSeparator();
        System.out.println(YELLOW + "     ██╗      █████╗ ███████╗████████╗    " + RESET);
        System.out.println(YELLOW + "     ██║     ██╔══██╗██╔════╝╚══██╔══╝    " + RESET);
        System.out.println(YELLOW + "     ██║     ███████║███████╗   ██║        " + RESET);
        System.out.println(YELLOW + "     ██║     ██╔══██║╚════██║   ██║        " + RESET);
        System.out.println(YELLOW + "     ███████╗██║  ██║███████║   ██║        " + RESET);
        System.out.println(YELLOW + "     ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═╝       " + RESET);
        System.out.println(RED +    "          W A R R I O R                    " + RESET);
        printSeparator();
        System.out.println(CYAN +   "  You are the last defender of the fortress." + RESET);
        System.out.println(CYAN +   "  Endless waves of enemies approach.         " + RESET);
        System.out.println(CYAN +   "  Fight until your last breath.              " + RESET);
        printSeparator();
    }
    

    public static void printDeath() {
        clearScreen();
        printSeparator();
        System.out.println(RED + "  ██████╗ ███████╗ █████╗ ██████╗ " + RESET);
        System.out.println(RED + "  ██╔══██╗██╔════╝██╔══██╗██╔══██╗" + RESET);
        System.out.println(RED + "  ██║  ██║█████╗  ███████║██║  ██║" + RESET);
        System.out.println(RED + "  ██║  ██║██╔══╝  ██╔══██║██║  ██║" + RESET);
        System.out.println(RED + "  ██████╔╝███████╗██║  ██║██████╔╝" + RESET);
        System.out.println(RED + "  ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝ " + RESET);
        printSeparator();
        System.out.println(YELLOW + "  The fortress has fallen. You fought bravely." + RESET);
    
    }


}

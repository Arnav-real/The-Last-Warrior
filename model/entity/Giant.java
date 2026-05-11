package model.entity;
import java.util.*;

public class Giant extends Enemy{
    private int turnCounter = 0;

    public Giant() {
        super("Giant", 100, 100, 20, 10, 20, 25);
    }

    public void attack(Entity target){
        target.takeDamage(atk);
    }

    public void specialAction(Warrior warrior, List<Enemy> allies) {
        turnCounter++;
        if(turnCounter%3 == 0) { 
            System.out.println("Giant is exhausted and skips a turn!");
        } 
        else {
            attack(warrior);
        }
    }

    public String toString() {
        return "🗿 " + super.toString();
    }
}
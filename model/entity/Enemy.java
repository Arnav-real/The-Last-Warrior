package model.entity;
import java.util.*;

public abstract class Enemy extends Entity {
    private boolean isStunned = false;
    private int goldReward;
    
    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }

    private int xpReward;

    public Enemy(String name, int hp, int maxHp, int atk, int def, int gold, int xp){
        super(name, hp, maxHp, atk, def);
        this.goldReward = gold;
        this.xpReward = xp;
    };

    public void scaleToWave(int waveNumber) {
        hp += waveNumber*3;
        maxHp += waveNumber*3;
        atk += waveNumber*2;
        def += waveNumber*1;
    }

    public abstract void specialAction(Warrior warrior, List<Enemy> allies);

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxHp(){
        return maxHp;
    }


    public int get_gold() {
        return goldReward;
    };

    public void set_gold(int value) {
        goldReward = value;
    };

    public int get_xp() {
        return xpReward;
    };

    public void set_xp(int value) {
        xpReward = value;
    };

}

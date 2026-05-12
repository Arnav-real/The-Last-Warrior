package model.entity;

import model.item.*;
import strategy.*;
import java.util.*;

public class Warrior extends Entity{
    private boolean lastStandActive = false;
    private boolean frostBloodActive = false;
    private boolean vampireStrikeActive = false;
    private boolean thunderClapActive = false;
    private boolean deathBargainActive = false;

    private boolean ballistaActive = false;
    private boolean oilTrapActive = false;
    private boolean magicSealActive = false;
    private boolean healingSpringActive = false;

    private int ap;
    private int orignalAtk = 0;
    private int berserkerWavesRemaing = 0;
    private int maxAp;
    private int gold;
    private int level;
    private int xp;
    private List<Ability> abilityList;
    private List<PowerUp> powerList;
    private List<Item> inventory = new ArrayList<>();

    public Warrior(String name) {
        super(name, 250, 250, 35, 15);
        this.ap = 120;
        this.maxAp = 120;
        this.gold = 0;
        this.level = 1;
        this.xp = 0;
        this.powerList = new ArrayList<>();
        this.abilityList = new ArrayList<>();
    }

    public void levelUp() {
        level++;
        maxHp += 20;
        hp = maxHp;
        maxAp += 10;
        ap = maxAp;
        atk += 5;
        def += 3;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int HP) {
        hp = HP;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public void setBallistaActive(boolean ballistaActive) {
        this.ballistaActive = ballistaActive;
    }

    public void setOilTrapActive(boolean oilTrapActive) {
        this.oilTrapActive = oilTrapActive;
    }

    public void setMagicSealActive(boolean magicSealActive) {
        this.magicSealActive = magicSealActive;
    }

    public void setHealingSpringActive(boolean healingSpringActive) {
        this.healingSpringActive = healingSpringActive;
    }

    public void setThunderClapActive(boolean bool) {
        thunderClapActive = bool;
    }

    public void setDeathBargainActive(boolean bool) {
        deathBargainActive = bool;
    }

    public void setlastStandActive(boolean bool) {
        lastStandActive = bool;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getOrignalAtk() {
        return orignalAtk;
    }

    public void setOrignalAtk(int orignalAtk) {
        this.orignalAtk = orignalAtk;
    }

    public int getMaxAp() {
        return maxAp;
    }

    public void setMaxAp(int maxAp) {
        this.maxAp = maxAp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }

    public List<PowerUp> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<PowerUp> powerList) {
        this.powerList = powerList;
    }

    public void setFrostBloodActive(boolean bool) {
        frostBloodActive = bool;
    }

    public void setVampireStrikeActive(boolean bool) {
        vampireStrikeActive = bool;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atack) {
        atk = atack;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int defense) {
        def = defense;
    }

    public void setBerserkerWaves(int waves) {
        berserkerWavesRemaing = waves;
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(getAtk());
    }
}

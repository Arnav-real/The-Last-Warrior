package model.entity;

abstract class Entity {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int atk;
    protected int def;

    public Entity(String name, int hp, int maxHp, int atk, int def){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.atk = atk;
    }

    public void takeDamage(int damage) {
        int net_damage = damage - def;
        hp = Math.max(0, hp - net_damage);
    }

    public void takeDamageIgnoreDefense(int damage) {
        hp = Math.max(0, hp - damage);
    }

    boolean isAlive(){
        return hp > 0;
    }

    abstract void attack(Entity target);

    public String toString() {
        return name + " | HP: " + hp + "/" + maxHp + " | ATK: " + atk + " | DEF: " + def;
    }

}

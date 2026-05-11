package model.item;

import model.entity.Warrior;

public abstract class Item {
    private String name;
    private String description;
    private int cost;

    public Item(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public abstract void use(Warrior warrior);

    // getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getCost() { return cost; }

    @Override
    public String toString() {
        return name + " — " + description + " | Cost: " + cost;
    }
}
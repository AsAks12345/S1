package assignment2.simplerpg.Entity;

public abstract class Hero {
    protected String name;
    protected String occupation;
    protected int health;
    protected int healthMax;
    protected int attack;

    public boolean attack(Monster monster) {
        monster.setHealth(monster.getHealth() - attack);
        return monster.getHealth() <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

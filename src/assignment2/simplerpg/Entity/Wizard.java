package assignment2.simplerpg.Entity;

public class Wizard extends Hero {
    public Wizard(String name) {
        setAttack(20);
        setHealth(70);
        setHealthMax(70);
        setName(name);
        setOccupation("wizard");
    }
}

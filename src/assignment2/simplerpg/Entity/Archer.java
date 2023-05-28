package assignment2.simplerpg.Entity;

public class Archer extends Hero{
    public Archer(String name) {
        setAttack(15);
        setHealth(80);
        setHealthMax(80);
        setName(name);
        setOccupation("archer");
    }
}

package assignment2.simplerpg.Entity;

public class SwordMan extends Hero{
    public SwordMan(String name) {
        setAttack(10);
        setHealth(100);
        setHealthMax(100);
        setName(name);
        setOccupation("SwordMan");
    }
}

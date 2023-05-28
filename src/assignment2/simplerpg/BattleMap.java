package assignment2.simplerpg;

import assignment2.simplerpg.Entity.Hero;
import assignment2.simplerpg.Entity.Monster;

import javax.swing.*;
import java.util.ArrayList;

public class BattleMap extends javax.swing.JPanel {

    /**
     * Link monster GUI and monster objects
     */
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<JLabel> labels = new ArrayList<>();

    /**
     * Check if all monsters are eliminated
     * @return
     */
    public boolean isEliminated() {
        for (int i = 0; i < labels.size(); i++) {
            if (monsters.get(i).getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    public void fillMonsters() {
        for (int i = 0; i < labels.size(); i++) monsters.add(new Monster());
    }

    public int getIndex(Monster monster) {
        return monsters.indexOf(monster);
    }

    public int getIndex(JLabel label) {
        return labels.indexOf(label);
    }

    public Monster getMonster(JLabel label) {
        return monsters.get(getIndex(label));
    }

    public JLabel getLabel(Monster monster) {
        return labels.get(getIndex(monster));
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<JLabel> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<JLabel> labels) {
        this.labels = labels;
    }
}

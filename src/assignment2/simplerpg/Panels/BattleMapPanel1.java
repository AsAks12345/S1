/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package assignment2.simplerpg.Panels;

import assignment2.simplerpg.BattleMap;
import assignment2.simplerpg.Dialog.LoseDialog;
import assignment2.simplerpg.Dialog.RoundFinishDialog;
import assignment2.simplerpg.Entity.Hero;
import assignment2.simplerpg.Entity.Monster;
import assignment2.simplerpg.SimpleRPGStart;

import javax.swing.*;

/**
 *
 * @author yucha
 */
public class BattleMapPanel1 extends BattleMap {

    SimpleRPGStart root;

    /**
     * Creates new form BattleMapPanel
     */
    public BattleMapPanel1(SimpleRPGStart root) {
        this.root = root;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SwordMan small.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Enemy small.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attack(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Enemy small.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attack(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(92, 92, 92)
                .addComponent(jLabel3)
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76))))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 136, 810, 540));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 50)); // NOI18N
        jTextField1.setText("Cave");
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 28, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setText("Scores:");
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 40, -1, -1));

        jTextField3.setEditable(false);
        jTextField3.setText("Health:");
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 72, -1, -1));

        jTextField4.setEditable(false);
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 40, -1, -1));

        jTextField5.setEditable(false);
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 72, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cave.png"))); // NOI18N
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 136, -1, -1));

        getLabels().add(jLabel3);
        getLabels().add(jLabel4);
        fillMonsters();
    }// </editor-fold>//GEN-END:initComponents

    private void attack(java.awt.event.MouseEvent evt) {
        JLabel l = (JLabel) evt.getSource();
        Monster m = getMonster(l);

        // Update monster's hp
        m.setHealth(m.getHealth() - hero.getAttack());
        if (m.getHealth() <= 0) {
            hero.setScore(hero.getScore() + 100);
            l.setVisible(false);
        }

        // Update hero's hp
        hero.deductHealth(m.getAttack());
        jTextField5.setText(String.valueOf(hero.getHealth()));

        if (isEliminated()) {
            // Case round win: all monsters are eliminated
            hero.setHealth(hero.getHealth() + 100);
            hero.setArmor(true);
            RoundFinishDialog rfd = new RoundFinishDialog(root);
            rfd.setVisible(true);
            // Next battle map scene
            BattleMapPanel2 bmp2 = (BattleMapPanel2) root.getBattleMapPanel2();
            bmp2.setHero(hero);
            root.setPanelsVisible(root.getBattleMapPanel2());
        } else if (hero.getHealth() <= 0) {
            // Case lose: monster remaining and hero's hp <= 0
            LoseDialog ld = new LoseDialog(root);
            ld.setVisible(true);
            root.setPanelsVisible(root.getStartPagePanel());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    /**
     * Set Hero and initialize score and health textfields
     * @param hero
     */
    public void setHero(Hero hero) {
        this.hero = hero;
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/" + hero.getOccupation() + " small.png")));
        jTextField4.setText(String.valueOf(hero.getScore()));
        jTextField5.setText(String.valueOf(hero.getHealth()));
    }
}

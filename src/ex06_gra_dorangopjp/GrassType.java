/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex06_gra_dorangopjp;

/**
 *
 * @author pj
 */
public class GrassType extends Monster {
    private int hpBoost;
    
    public GrassType(String n, int m, int base) {
        super(n, "Grass", "Water", "Fire", m, base);
        hpBoost = 0;
    }
    
    @Override
    public void rest() {
        // Heal half of maxHP, max at maxHP
        hp += maxHP * 0.5;
        if(hp > maxHP) hp = maxHP;
        System.out.println(getName() + " rested. It's health is now " + hp + ".");
    }
    
    @Override
    public void special() {
        // Increase maxHP by 20%
        // I assume this is what the instruction means????!??! bc if its hp
        // why would u use this if u have a better heal anyway
        // Keep track of HP boosts with hpBoost variable
        hpBoost += maxHP * 0.2;
        maxHP *= 1.2;
        System.out.println(getName() + " used its special! Its maximum HP was raised to " + (int) (maxHP * 1.2) + " HP!");
    }
    
    @Override
    public void resetStats() {
        // Only prints out statement if there was ever a boost in the first place.
        if (hpBoost != 0) {
            // Subtracts atk by how much the atk was boosted in battle, then resets hpBoost
            maxHP -= hpBoost;
            hpBoost = 0;
            System.out.println(getName() + "'s boosts disappeared.");
        }
    }
}

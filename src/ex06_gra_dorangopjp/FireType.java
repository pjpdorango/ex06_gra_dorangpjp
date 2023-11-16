/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex06_gra_dorangopjp;

/**
 *
 * @author pj
 */
public class FireType extends Monster { 
    private int atkBoost;
    
    public FireType(String n, int m, int base) {
        super(n, "Fire", "Grass", "Water", m, base);
        // Sets atk to 1.3x and def to 0.7x
        atk *= 1.3;
        def *= 0.7;
        atkBoost = 0;
    }
    
    @Override
    public void special(){
        // As long as hp can still be reduced by 10%
        if (hp > (maxHP * 0.1)) {
            // Increase atk by 2, and
            // reduce hp by 10% of maxHP
            atk += 2;
            hp -= maxHP * 0.1;
            
            // Add 2 to atkBoost to keep track of base attack
            atkBoost += 2;
            System.out.println(getName() + " reduced its HP by " + (int) (maxHP * 0.1) + " to increase its atk by 2!");
        }
    }
    
    @Override
    public void resetStats() {
        // Only prints out statement if there was ever a boost in the first place.
        if (atkBoost != 0) {
            // Subtracts atk by how much the atk was boosted in battle
            atk -= atkBoost;
            atkBoost = 0;
            System.out.println(getName() + "'s boosts disappeared.");
        }
    }
}

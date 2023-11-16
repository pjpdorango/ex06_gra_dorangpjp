/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex06_gra_dorangopjp;

/**
 *
 * @author pj
 */
public class WaterType extends Monster {
    private int defBoost;
    
    public WaterType(String n, int m, int base) {
        super(n, "Water", "Fire", "Grass", m, base);
        // Sets atk to 0.7x and atk to 1.3x
        atk *= 0.7;
        def *= 1.3;
        defBoost = 0;
    }
    
    @Override
    public void special() {
        // As long as hp can still be reduced by 10%
        if (hp > (maxHP * 0.1)) {
            // Increase def by 2, and
            // reduce hp by 10% of maxHP
            def += 2;
            defBoost += 2;
            hp -= maxHP * 0.1;
            System.out.println(getName() + " reduced its HP by " +(int) (maxHP * 0.1) + " to increase its def by 2!");
        }
    }
    
    @Override
    public void resetStats() {
        // Only prints out statement if there was ever a boost in the first place.
        if (defBoost != 0) {
            // Subtracts atk by how much the atk was boosted in battle, then resets hpBoost
            def -= defBoost;
            defBoost = 0;
            System.out.println(getName() + "'s boosts disappeared.");
        }
    }
}

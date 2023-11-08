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
    public FireType(String n, int m, int base) {
        super(n, "Fire", "Grass", "Water", m, base);
        // Sets atk to 1.3x and def to 0.7x
        atk *= 1.3;
        def *= 0.7;
    }
    
    @Override
    public void special(){
        // As long as hp can still be reduced by 10%
        if (hp > (maxHP * 0.1)) {
            // Increase atk by 2, and
            // reduce hp by 10% of maxHP
            atk += 2;
            hp -= maxHP * 0.1;
            System.out.println(getName() + " reduced its HP by " + (int) (maxHP * 0.1) + " to increase its atk by 2!");
        }
    }
}

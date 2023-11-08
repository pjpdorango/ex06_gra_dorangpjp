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
    public GrassType(String n, int m, int base) {
        super(n, "Grass", "Water", "Fire", m, base);
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
        // Heal by 20% of maxHP, max at maxHP
        hp += maxHP * 0.2;
        if (hp > maxHP) hp = maxHP;
        System.out.println(getName() + " healed " + (int) (maxHP * 0.2) + " HP!");
    }
}

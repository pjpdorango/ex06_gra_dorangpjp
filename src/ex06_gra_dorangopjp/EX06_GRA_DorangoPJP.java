/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex06_gra_dorangopjp;
import java.util.Random;

/**
 *
 * @author pj
 */
public class EX06_GRA_DorangoPJP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        // Will not be using these specific references since monsterList will be used instead,
        // but variables are still here for possible future use.
        Monster rowlet = new GrassType("Rowlet", 68, 55);
        Monster litten = new FireType("Litten", 45, 50);
        Monster popplio = new WaterType("Popplio", 50, 54);
        
        // Do 3 battles: One is index 0 vs 1, 1 vs 2, then 2 vs 0
        for (int i = 0; i < 3; i++) {
            // Generate the two monsters to battle
            Monster monster1 = (Monster) Monster.getMonsterList().get(i);
            int i2 = i + 1; // Temporary index of monster 2
            // If i2 is greater than monsterList, set to 0
            if (i2 > Monster.getMonsterList().size() - 1) {
                i2 = 0;
            }
            Monster monster2 = (Monster) Monster.getMonsterList().get(i2);
            
            System.out.println("----------------------------------------");
            System.out.println(monster1.getName() + " will battle against " + monster2.getName() + "!");
            System.out.println("----------------------------------------");
            
            System.out.println(monster1.getName() + " - " + monster1.getHP() + " HP");
            System.out.println(monster2.getName() + " - " + monster2.getHP() + " HP");
            int round = 1;
            while (monster1.getHP() > 0 && monster2.getHP() > 0) {
                Monster monster;
                Monster enemy;
                // For even rounds, monster1 will attack.
                // For odd rounds, monster2 will attack.
                if (round % 2 == 0) {
                    monster = monster1;
                    enemy = monster2;
                } else {
                    monster = monster2;
                    enemy = monster1;
                }
                
                // Choosing a random choice (Attack, Guard, Charge, Rest, or Special)
                // Guard, Charge, Rest and Special each have 1/9 chance to occur
                // Attack has 5/9 chance to occur (battles move too slow otherwise)
                int nextMove = rand.nextInt(8);
                switch (nextMove) {
                    case 0:
                        monster.attack(enemy);
                        break;
                    case 1:
                        monster.guard();
                        break;
                    case 2:
                        monster.charge();
                        break;
                    case 3:
                        monster.rest();
                        break;
                    case 4:
                        monster.special();
                        break;
                    default:
                        monster.attack(enemy);
                        break;
                }
                
                round++;
            }
            
            monster1.resetHealth();
            monster2.resetHealth();
        }
    }
    
}

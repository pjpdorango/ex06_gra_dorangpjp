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
        // Will not be using these specific references since monsterList will be used instead,
        // but variables are still here for possible future use.
        Monster rowlet = new GrassType("Rowlet", 68, 55);
        Monster litten = new FireType("Litten", 45, 50);
        Monster popplio = new WaterType("Popplio", 50, 54);
        
        // Do 3 battles: Monster i vs Monster i + 1 (unless greater than 2, then turn to 0)
        // 0 vs 1
        // 1 vs 2
        // 2 vs 0
        for (int i = 0; i < 3; i++) {
            // Generate the two monsters to battle
            // Since there are only 3 enemies, i1 is 0 - 2 (3 options)
            // i1 and i2 are temporary indexes of monster 1 and 2 respectively
            int i1 = i % Monster.getMonsterList().size();
            int i2 = i1 + 1;
            
            // If i2 is greater than monsterList, reset to 0
            if (i2 > Monster.getMonsterList().size() - 1) {
                i2 = 0;
            }
            
            // Set monster1 and monster2 to monster at index i1 and i2 respectively
            Monster monster1 = (Monster) Monster.getMonsterList().get(i1);
            Monster monster2 = (Monster) Monster.getMonsterList().get(i2);
                     
            battle(monster1, monster2);
        }
    }
    
    public static void battle(Monster monster1, Monster monster2) {
        Random rand = new Random();
        int round = 1;
            
        // BATTLE START
        System.out.println("----------------------------------------");
        System.out.println(monster1.getName() + " will battle against " + monster2.getName() + "!");
        System.out.println("----------------------------------------");

        System.out.println(monster1.getName() + " - " + monster1.getHP() + " HP");
        System.out.println(monster2.getName() + " - " + monster2.getHP() + " HP");
        // Continue while both monsters have hp higher than 0.
        while (monster1.getHP() > 0 && monster2.getHP() > 0) {
            Monster monster;
            Monster enemy;

            // For even rounds, monster1 will attack.
            // For odd rounds, monster2 will attack.
            // This way, when a pokemon faints, the battle ends immediately, and the fainted pokemon
            // doesn't get a turn.
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
            int nextMove = rand.nextInt(9);
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
        
        System.out.println(monster1.getName() + " - " + monster1.getHP() + " HP");
        System.out.println(monster2.getName() + " - " + monster2.getHP() + " HP");

        monster1.resetHealth();
        monster2.resetHealth();

        monster1.resetStats();
        monster2.resetStats();
    }
}

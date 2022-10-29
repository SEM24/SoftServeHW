/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4;

import com.khomsi.softServe.homework4.enemies.Zombie;
import com.khomsi.softServe.homework4.heroes.Archer;
import com.khomsi.softServe.homework4.heroes.Mage;
import com.khomsi.softServe.homework4.heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {
        new TrainingGround().runBattle();
    }

    private void runBattle() {
        Warrior warrior = new Warrior("Bob");
        Archer archer = new Archer("Dima");
        Mage mage = new Mage("Vlad");
        Zombie zombie = new Zombie(100);

        warrior.attackEnemy(zombie);
        archer.attackEnemy(zombie);
        mage.attackEnemy(zombie);
        System.out.println(zombie.isAlive() ? "Zombie is still alive" : "Zombie is dead");
    }
}

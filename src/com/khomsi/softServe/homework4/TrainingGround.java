/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4;

import com.khomsi.softServe.homework4.character_type.Enemy;
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
        Enemy enemy = new Enemy(100);

        warrior.attackEnemy(enemy);
        archer.attackEnemy(enemy);
        mage.attackEnemy(enemy);
    }
}

/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4;

import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.heroes.Mage;

public class BattleGround {
    public static void main(String[] args) {
        new BattleGround().startBattle();
    }

    private void startBattle() {
        Mage mage = new Mage("Vlad");
        Enemy enemy = new Enemy(100);

        mage.attackEnemy(enemy);
        System.out.println(enemy.isAlive() ? "Enemy is still alive" : "Enemy is dead");
    }
}

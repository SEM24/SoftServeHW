/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4;

import com.khomsi.softServe.homework4.enemies.Zombie;
import com.khomsi.softServe.homework4.heroes.Mage;

public class BattleGround {


    public static void main(String[] args) {
        new GameTools().startGame();
//        new BattleGround().startBattle();
    }


    private void startBattle() {
//        TODO
//        Different enemies = different hp/damage
//        Different heroes = different hp and damage (someone damages powerful, but has a low hp)
//        Make the game more balanced
        Mage mage = new Mage("Vlad");
        Zombie zombie = new Zombie(100);

        mage.attackEnemy(zombie);
        System.out.println(zombie.isAlive() ? "Enemy is still alive" : "Enemy is dead");
        if (zombie.isAlive()) {
            zombie.attackHero(mage);
        }
    }
}


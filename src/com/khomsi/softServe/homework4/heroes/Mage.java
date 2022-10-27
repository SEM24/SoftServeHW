/*
 * Author: SEM
 */


package com.khomsi.softServe.homework4.heroes;

import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

import java.util.Random;

public class Mage extends Hero {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        String className = this.getClass().getSimpleName() + " ";
        System.out.println(className + getName() + " has attacked the enemy");
        enemy.takeDamage(new Random().nextInt(100));
    }
}

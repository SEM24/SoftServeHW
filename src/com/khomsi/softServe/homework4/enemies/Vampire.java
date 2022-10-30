/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.enemies;

import com.khomsi.softServe.homework4.Tools;
import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

public class Vampire extends Enemy {

    public Vampire(int health) {
        super(health);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public void takeDamage(int damage) {
//        Chance to take the damage to be revived
        if (getHealth() <= 0 && Math.random() * 10 + 1 <= 3.5) {
            setHealth(getHealth() + damage);
            System.out.println("Oh no! Vampire got revived by damage amount. He got " + getHealth() + " HP!!");
        } else {
            setHealth(getHealth() - damage);
        }
        System.out.println(getHealth() <= 0 ? "Enemy hp: 0" : "Enemy hp: " + getHealth());

    }

    @Override
    public void attackHero(Hero hero) {
        String className = this.getClass().getSimpleName() + " ";
        double chance = 1.5;
        int criticalDamage = 120;
        int damage = 70;
        new Tools().showEnemyAttack(hero, className, chance, criticalDamage, damage);
    }


    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}

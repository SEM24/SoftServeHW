/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.enemies;

import com.khomsi.softServe.homework4.Tools;
import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

public class Golem extends Enemy {
    public Golem(int health) {
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
//        Chance to avoid damage and get heal
        double changeToDeflect = 2.5;
        if (Math.random() * 10 + 1 <= changeToDeflect) {
            setHealth(getHealth() + 10);
        } else {
            setHealth(getHealth() - damage);
        }
        System.out.println(getHealth() <= 0 ? "Enemy hp: 0" : "Enemy hp: " + getHealth());
    }

    @Override
    public void attackHero(Hero hero) {
        String className = this.getClass().getSimpleName() + " ";
        double chance = 2.5;
        int criticalDamage = 105;
        int damage = 90;
        new Tools().showEnemyAttack(hero, className, chance, criticalDamage, damage);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}

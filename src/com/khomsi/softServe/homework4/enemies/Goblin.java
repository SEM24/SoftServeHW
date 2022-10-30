/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.enemies;

import com.khomsi.softServe.homework4.Tools;
import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

public class Goblin extends Enemy {
    public Goblin(int health) {
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
        setHealth(getHealth() - damage);
        System.out.println(getHealth() <= 0 ? "Enemy hp: 0" : "Enemy hp: " + getHealth());
    }

    @Override
    public void attackHero(Hero hero) {
        String className = this.getClass().getSimpleName() + " ";
        double chance = 4.5;
        int criticalDamage = 100;
        int damage = 50;
        new Tools().showEnemyAttack(hero, className, chance, criticalDamage, damage);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}

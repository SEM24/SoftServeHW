/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.enemies;

import com.khomsi.softServe.homework4.Tools;
import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

public class Zombie extends Enemy {

    public Zombie(int health) {
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
        if (getHealth() <= 0 && Math.random() * 10 + 1 <= 3.5) {
            setHealth((int) (Math.random() * 70));
            System.out.println("Oh no! Zombie resurrected and has " + getHealth() + " HP!!");
        }
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

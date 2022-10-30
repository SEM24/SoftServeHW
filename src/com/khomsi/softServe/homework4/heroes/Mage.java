/*
 * Author: SEM
 */


package com.khomsi.softServe.homework4.heroes;

import com.khomsi.softServe.homework4.Tools;
import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

import java.util.List;

public class Mage extends Hero {

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        String className = this.getClass().getSimpleName() + " ";
        int min = 30;
        int max = 90;
        int diff = max - min;
        new Tools().amountOfDamage(enemy, className, min, diff);
    }

    @Override
    public void attackEnemies(List<Enemy> enemies, Hero hero) {
        int min = 50;
        int max = 95;
        double chance = 3.5;
        new Tools().attackEachEnemy(enemies, min, max, hero, chance);
    }


    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getHealth() <= 0 ? "Hero hp: 0" : "Hero hp: " + getHealth());
//      25%  chance to heal himself if the hp lower than 50
        reviveHero();
    }

    private void reviveHero() {
        if (getHealth() < 50 && (Math.random() * 10 + 1 <= 2.5)) {
            setHealth(getHealth() + (int) (Math.random() * 60));
            System.out.println("Hero revived himself!! HP:" + getHealth());
        }
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}

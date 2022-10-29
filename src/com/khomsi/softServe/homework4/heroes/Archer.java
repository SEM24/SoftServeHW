/*
 * Author: SEM
 */


package com.khomsi.softServe.homework4.heroes;

import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

import java.util.List;
import java.util.Random;

public class Archer extends Hero {
    public Archer(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        String className = this.getClass().getSimpleName() + " ";
        System.out.println(className + getName() + " has attacked the enemy");
        enemy.takeDamage(new Random().nextInt(100));
    }

    @Override
    public void attackEnemies(List<Enemy> enemies, Hero hero) {
        for (Enemy enemy : enemies) {
            System.out.println("You attacked " + enemy.getClass().getSimpleName() + "!!");
            enemy.takeDamage(new Random().nextInt(100));
            System.out.println(enemy.isAlive() ? enemy.getClass().getSimpleName() +
                    " is still alive" : enemy.getClass().getSimpleName() + " is dead");
        }
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getHealth() <= 0 ? "Hero hp: 0" : "Hero hp: " + getHealth());
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}

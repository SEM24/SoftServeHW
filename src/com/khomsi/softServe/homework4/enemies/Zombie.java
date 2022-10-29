/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.enemies;

import com.khomsi.softServe.homework4.GameTools;
import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

import java.util.Random;

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
    }

    @Override
    public void attackHero(Hero hero) {
        String className = this.getClass().getSimpleName() + " ";
        GameTools gameTools = new GameTools();
        gameTools.printTitle(className + " has attacked the you!!");

        hero.takeDamage(new Random().nextInt(100));
        gameTools.printTitle(hero.isAlive() ? hero.getClass().getSimpleName() +
                " is still alive" : hero.getClass().getSimpleName() + " is dead");
        System.out.println();
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}

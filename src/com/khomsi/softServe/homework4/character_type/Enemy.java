/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.character_type;

public abstract class Enemy implements Mortal {
    int health;

    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void takeDamage(int damage);

    public abstract void attackHero(Hero hero);

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}


/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.character_type;

public class Enemy implements Mortal {
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

    public void takeDamage(int damage) {
        setHealth(health - damage);
        System.out.println(getHealth() <= 0 ? "Enemy hp: 0" : "Enemy hp: " + getHealth());
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}


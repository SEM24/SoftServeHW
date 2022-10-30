/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.character_type;

import java.util.List;

public abstract class Hero implements Mortal {
    String name;
    int health;

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);

    public abstract void attackEnemies(List<Enemy> enemy, Hero hero);

    public abstract void takeDamage(int damage);

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

}

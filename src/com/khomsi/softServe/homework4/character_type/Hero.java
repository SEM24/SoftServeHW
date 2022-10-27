/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4.character_type;

public abstract class Hero {
    String name;

    protected Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);

}

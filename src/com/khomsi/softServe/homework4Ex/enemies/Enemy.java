/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex.enemies;

import com.khomsi.softServe.homework4Ex.tools.Character;

public class Enemy extends Character {

    //var to store the xp of hero
    int heroXp;

    public Enemy(String name, int heroXp) {
        //TODO generate random xp and HP, change the HP for each enemy
        super(name, (int) (Math.random() * heroXp + heroXp / 3 + 5),
                (int) (Math.random() * (heroXp / 4 + 2) + 1));
        //assign var
        this.heroXp = heroXp;
    }

    @Override
    public int attack() {
        return (int) (Math.random() * (heroXp / 4 + 1) + xp / 4 + 10);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (heroXp / 4 + 1) + xp / 4 + 3);
    }
}

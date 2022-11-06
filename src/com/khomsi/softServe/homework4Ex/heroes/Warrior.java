/*
 * Author: SEM
 */


package com.khomsi.softServe.homework4Ex.heroes;

public class Warrior extends Hero {

    public Warrior(String name, int maxHp, int xp, int numAttackBuffs,
                   int numDefendBuffs, int gold, int restLeft, int pots) {
        super(name, maxHp, xp, numAttackBuffs, numDefendBuffs, gold, restLeft, pots);
    }


    @Override
    public int attack() {
        return (int) (Math.random() * (xp / 4 + numAttackBuffs * 3 + 3)
                + xp / 10 + numAttackBuffs * 2 + numDefendBuffs + 2);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp / 4 + numDefendBuffs * 4 + 4)
                + xp / 10 + numDefendBuffs * 2 + numAttackBuffs + 1);
    }
}

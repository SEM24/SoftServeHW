/*
 * Author: SEM
 */



package com.khomsi.softServe.homework4Ex.enemies;

public abstract class Character {
    //Variables
    public String name;
    //Attributes all characters have
    public int maxHp, hp, xp;

    public Character(String name, int maxHp, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
    }

    //Methods for characters
    public abstract int attack();

    public abstract int defend();

}

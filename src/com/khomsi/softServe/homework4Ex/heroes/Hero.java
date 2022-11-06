/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex.heroes;

import com.khomsi.softServe.homework4Ex.tools.Tools;

public abstract class Hero {
    private static Tools TOOLS = new Tools();
    //Variables
    public String name;
    //Attributes all characters have
    public int maxHp, hp, xp;

    //integers to store num of skills
    //the damage and defend depends on qty of this buffs
    public int numAttackBuffs, numDefendBuffs;

    public String[] attackBuffs = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defendBuffs = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    //Bonuses for hero
    public int gold, restLeft, pots;

    protected Hero(String name, int maxHp, int xp, int numAttackBuffs,
                   int numDefendBuffs, int gold, int restLeft, int pots) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
        this.numAttackBuffs = numAttackBuffs;
        this.numDefendBuffs = numDefendBuffs;
        this.gold = gold;
        this.restLeft = restLeft;
        this.pots = pots;

        chooseSkills();
    }

    //give user choose skills
    public void chooseSkills() {
        TOOLS.clearConsole();
        TOOLS.printHeading("Choose a skills");
        //each level hero get skill, every level skills become better
        System.out.println("1 - " + attackBuffs[numAttackBuffs]);
        System.out.println("2 - " + defendBuffs[numDefendBuffs]);
        //give input the choice for user
        int input = TOOLS.readInt("-->", 2);
        switch (input) {
            case 1 -> {
                TOOLS.printHeading("You chose " + attackBuffs[numAttackBuffs] + "!");
                numAttackBuffs++;
            }
            case 2 -> {
                TOOLS.printHeading("You chose " + defendBuffs[numDefendBuffs] + "!");
                numDefendBuffs++;
            }
        }
        TOOLS.pressToContinue();
    }

    //Methods for characters
    public abstract int attack();

    public abstract int defend();
}

/*
 * Author: SEM
 */


package com.khomsi.softServe.homework4Ex.heroes;

import com.khomsi.softServe.homework4Ex.tools.Character;
import com.khomsi.softServe.homework4Ex.tools.Tools;

//todo change player for unique heroes,
// extends from hero, not from character
public class Player extends Character {

    private static Tools TOOLS = new Tools();

    //integers to store num of skills
    //the damage and defend depends on qty of this buffs
    public int numAttackBuffs, numDefendBuffs;


    //Bonuses for hero
    public int gold, restLeft, pots;
    public String[] attackBuffs = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defendBuffs = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};


    //Player specific constructor
    public Player(String name) {
        //call the constructor of superclass, user hardCode to add hp ect
        //TODO hardcode, change it for each hero
        super(name, 100, 10);
        //Setting of upgrades to 0
        this.numAttackBuffs = 0;
        this.numDefendBuffs = 0;
        this.gold = 6;
        this.restLeft = 1;
        this.pots = 0;
        //let the player choose a skills when creating a new character
        chooseSkills();
    }

    //give user choose skills
    public void chooseSkills() {
        TOOLS.clearConsole();
        TOOLS.printHeading("Choose a skills:");
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

    @Override
    public int attack() {
        return (int) (Math.random() * (xp / 4 + numAttackBuffs * 3 + 3)
                + xp / 10 + numAttackBuffs * 2 + numDefendBuffs + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp / 4 + numDefendBuffs * 3 + 3)
                + xp / 10 + numDefendBuffs * 2 + numAttackBuffs + 1);
    }
}

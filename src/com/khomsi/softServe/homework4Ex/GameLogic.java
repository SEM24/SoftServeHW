/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex;

import com.khomsi.softServe.homework4Ex.enemies.Enemy;
import com.khomsi.softServe.homework4Ex.heroes.Archer;
import com.khomsi.softServe.homework4Ex.heroes.Hero;
import com.khomsi.softServe.homework4Ex.heroes.Mage;
import com.khomsi.softServe.homework4Ex.heroes.Warrior;
import com.khomsi.softServe.homework4Ex.tools.Story;
import com.khomsi.softServe.homework4Ex.tools.Tools;

import java.util.Random;

public class GameLogic {
    //TODO make battle between one hero and different enemies, add buffs to enemy, like zombie
    static Tools tools = new Tools();
    static Hero hero;
    static Story story = new Story();
    static Random random = new Random();
    static boolean runGame;
    //Events that can be happened during the trip
    static String[] randomEvents = {"Battle", "Battle", "Rest", "Battle", "Rest", "Shop"};

    //names for enemies
    static String[] enemies = {"Draugr", "Falmer", "Draugr Death Overlord",
            "Wolf", "Necromancer", "Skeleton"};


    static int place = 0, act = 1;
    static String[] places = {"Whiterun", "High Hrothgar", "Sovngrade",
            "Markarth", "Morthal", "Riften", "Sovngarde"};


    //Start the game
    public void startGame() {
        tools.clearConsole();
        tools.printSeparator(45);
        tools.printSeparator(30);
        System.out.println("\tSKYRIM RPG GAME");
        tools.printSeparator(30);
        tools.printSeparator(45);
        tools.pressToContinue();

        //getting the player name
        String userName = tools.getUserName();

        //Show story to user

        story.storyInto();

        hero = chooseCharacter(userName);
        story.firstActInto();
        //start main game loop
        runGame = true;
        loopGame();
    }

    private Hero chooseCharacter(String name) {
        tools.chooseCharacterText();
        int input = tools.readInt("-->", 3);

        int randomHp;
        int randomGold;
        if (input == 1) {
            randomHp = random.nextInt(100, 150);
            randomGold = random.nextInt(3, 13);

            hero = new Warrior(name, randomHp, 10, 0, 0,
                    randomGold, 2, 0);
        } else if (input == 2) {
            randomHp = random.nextInt(90, 115);
            randomGold = random.nextInt(2, 14);

            hero = new Mage(name, randomHp, 15, 0, 0,
                    randomGold, 0, 2);
        } else if (input == 3) {
            randomHp = random.nextInt(100, 130);
            randomGold = random.nextInt(4, 15);

            hero = new Archer(name, randomHp, 11, 0, 0,
                    randomGold, 1, 1);
        }
        return hero;
    }

    private void loopGame() {
        while (runGame) {
            printMenu();
            int input = tools.readInt("-->", 3);
            switch (input) {
                case 1 -> startTheStoryGame();
                case 2 -> characterInfo();
                case 3 -> runGame = false;
            }
        }
    }


    private void characterInfo() {
        tools.clearConsole();
        tools.printHeading("\tDRAGONBORN STATS");
        System.out.println(hero.name + "\tHP: " + hero.hp + "/" + hero.maxHp);
        tools.printSeparator(30);
        System.out.println("Hero type: " + hero.getClass().getSimpleName());
        tools.printSeparator(30);
        System.out.println("XP: " + hero.xp + "\tGold: " + hero.gold);
        tools.printSeparator(30);
        System.out.println("Potions left: " + hero.pots);
        tools.printSeparator(30);
        if (hero.numAttackBuffs > 0) {
            System.out.println("Attack buffs: "
                    + hero.attackBuffs[hero.numAttackBuffs - 1]);
            tools.printSeparator(20);
        }
        if (hero.numDefendBuffs > 0) {
            System.out.println("Defending buffs: " +
                    hero.defendBuffs[hero.numDefendBuffs - 1]);
            tools.printSeparator(20);
        }
        tools.pressToContinue();
    }

    private void startTheStoryGame() {
        //check if act must be increased
        checkAct();
        //if story is not in the last act(boss act)
        if (act != 4) randomEvent();
    }

    private void randomEvent() {
        //random num between 0 and length
        int eventNum = (int) (Math.random() * randomEvents.length);
        if (randomEvents[eventNum].equals("Battle")) randomBattle();
        else if (randomEvents[eventNum].equals("Rest")) takeRest();
        else shop();
    }

    private void shop() {
        tools.clearConsole();
        tools.printHeading("You found a shop in the city!\nHere's the offers:");
        int price = (int) (Math.random() * (10 + hero.pots * 3) + 10 + hero.pots);
        System.out.println("Magic potion: " + price + " gold");
        System.out.println("Hero's HP: : " + hero.hp + "\tHero's gold: " + hero.gold);
        tools.printSeparator(30);
        System.out.println("Do you want to buy one?\n 1 - YES, YES, YES!\n2 - No, not this time");
        int input = tools.readInt("-->", 2);
        if (input == 1) {
            if (hero.gold >= price) {
                tools.printHeading("You bought magic potion for " + price + " gold!");
                hero.pots++;
                hero.gold -= price;
            } else
                tools.printHeading("You don't have enough money! Try again later!");
            tools.pressToContinue();
        }
    }

    private void takeRest() {
        tools.clearConsole();
        if (hero.restLeft >= 1) {
            tools.printHeading("Do you want to rest? (" + hero.restLeft + " rest(s) left).");
            System.out.println("1 - YES, YES ,YES!\n2 - No, maybe next time.");
            int input = tools.readInt("-->", 2);
            if (input == 1) {
                tools.clearConsole();
                if (hero.hp < hero.maxHp) {
                    int hpRest = (int) (Math.random() * (hero.xp / 4 + 1) + 10);
                    hero.hp += hpRest;
                    if (hero.hp > hero.maxHp)
                        hero.hp = hero.maxHp;
                    System.out.println("You took a rest and restored " + hpRest + " health!");
                    System.out.println("Now you have " + hero.hp + "|" + hero.maxHp + " health!");
                    hero.restLeft--;
                } else
                    System.out.println("You have a full HP. You don't need to restore it!");
                tools.pressToContinue();
            }
        }
    }

    private int increasedHeroAttack() {
        //save calculated attack
        int newDamage = hero.attack();
        if (hero.numAttackBuffs != 0) {
            //Change the attack damage every time hero choose new skill
            switch (hero.attackBuffs[hero.numAttackBuffs - 1]) {
                case "Strength" -> newDamage += 4;
                case "Power" -> newDamage += 5;
                case "Might" -> newDamage += 7;
                case "Godlike Strength" -> newDamage += 11;
            }
        }
        return newDamage;
    }

    private int increasedHeroDefend() {
        //save calculated attack
        int newDefend = hero.defend();
        //Change the attack damage every time hero choose new skill
        if (hero.numDefendBuffs != 0) {
            switch (hero.defendBuffs[hero.numDefendBuffs - 1]) {
                case "Heavy Bones", "Stoneskin" -> newDefend += 1;
                case "Scale Armor" -> newDefend += 2;
                case "Holy Aura" -> newDefend += 4;
            }
        }
        return newDefend;
    }

    private void randomBattle() {
        tools.clearConsole();
        tools.printHeading("You reached the evil enemy. Your fight starts!!!");
        tools.pressToContinue();
        //create enemy with random name
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], hero.xp));
    }

    //Main battle method
    private void battle(Enemy enemy) {
        while (true) {
            tools.clearConsole();
            tools.printHeading(enemy.name + "\nHP: " + enemy.hp + "|" + enemy.maxHp);
            tools.printHeading(hero.name + "\nHP: " + hero.hp + "|" + hero.maxHp);
            System.out.println("Choose action:");
            tools.printSeparator(20);
            System.out.println("1 - Fight\n2 - Use Potion\n3 - Run away");
            int input = tools.readInt("-->", 3);
            if (input == 1) {
                //calc attack and took damage
                int dmg = increasedHeroAttack() - enemy.defend();
                int dmgTook = enemy.attack() - increasedHeroDefend();
                if (dmgTook < 0) {
                    //add dmg if hero defends well
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                hero.hp -= dmgTook;
                enemy.hp -= dmg;

                tools.clearConsole();
                tools.printHeading("\tBATTLE");
                System.out.println("You did " + dmg + " damage to the " + enemy.name + "!");
                tools.printSeparator(15);
                System.out.println("The " + enemy.name + " did " + dmgTook + " damage to you!");
                tools.pressToContinue();
                //check if battle is over
                //check if player is dead or no
                if (hero.hp <= 0) {
                    heroDied();
                    break;
                } else if (enemy.hp <= 0) {
                    tools.clearConsole();
                    tools.printHeading("You defeated the " + enemy.name + "!");
                    hero.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    boolean newRest = (Math.random() * 5 + 1 <= 3.25);
                    int goldEarned = (int) (Math.random() * enemy.xp);
                    if (newRest) {
                        hero.restLeft++;
                        System.out.println("You got extra rest!");
                    }
                    if (goldEarned > 0) {
                        hero.gold += goldEarned;
                        System.out.println("You got " + goldEarned
                                + " gold in your pocket from " + enemy.name + "!");
                    }
                    tools.pressToContinue();
                    break;
                }
            } else if (input == 2) {
                tools.clearConsole();
                if (hero.pots > 0 && hero.hp < hero.maxHp) {
                    tools.printHeading("Drink the potion? (" + hero.pots + " left).");
                    System.out.println("1 - YES, YES, YES!\n 2 - No, not this time...");
                    input = tools.readInt("-->", 2);
                    if (input == 1) {
                        hero.hp = hero.maxHp;
                        tools.clearConsole();
                        tools.printHeading("You drank potion, your HP was restored! \nHP: " + hero.hp);
                        tools.pressToContinue();
                    }
                } else {
                    tools.printHeading("You can't take potion because you are full/don't have it!");
                    tools.pressToContinue();
                }
            } else {
                if (act != 4) {
                    tools.clearConsole();
                    //35% chance to escape
                    if (Math.random() * 10 + 1 <= 3.5) {
                        tools.printHeading("You ran away from enemy!!");
                        tools.pressToContinue();
                        break;
                    } else {
                        tools.printHeading("You didn't run away!");
                        int dmgTook = enemy.attack();
                        System.out.println("You took " + dmgTook + " damage from " + enemy.name + "!");
                        tools.pressToContinue();
                        if (hero.hp <= 0) {
                            heroDied();
                        }
                    }
                } else {
                    tools.printHeading("You can't run away from BOSS!!!");
                    tools.pressToContinue();
                }
            }
        }
    }

    private void heroDied() {
        tools.clearConsole();
        tools.printHeading("You died....");
        tools.printHeading("You earned " + hero.xp +
                " XP on your trip. Try to earn more XP next time!!");
        System.out.println("Thanks for playing!!");
        runGame = false;
    }

    //update enemies for the next stage
    private String[] randomEnemies() {
        String[] newEnemies = {"Bandit Marauder", "Nightingale Sentinel", "Pyromancer",
                "Curalmil", "Draugr", "Vampire Nightstalker"};
        String[] result = new String[enemies.length];
        for (int i = 0; i < enemies.length; i++) {
            result[i] = newEnemies[(int) (Math.random() * newEnemies.length)];
        }
        return result;
    }

    //update events for the next stage
    private String[] randomEvents() {
        String[] newEvents = {"Battle", "Battle", "Rest", "Battle",
                "Battle", "Shop", "Battle"};
        String[] result = new String[randomEvents.length];
        for (int i = 0; i < enemies.length; i++) {
            result[i] = newEvents[(int) (Math.random() * newEvents.length)];
        }
        return result;
    }

    //Method that changes acts, depends on xp(experience) of player
    private void checkAct() {
        if (hero.xp >= 20 && act == 1) {
            act = 2;
            place = 1;
            //end of the first act
            story.firstActOutro();
            //level up
            hero.chooseSkills();
            story.secondActInto();

            enemies = randomEnemies();

            randomEvents = randomEvents();
        } else if (hero.xp >= 60 && act == 2) {
            act = 3;
            place = 2;
            //end of the second act
            story.secondActOutro();
            //level up
            hero.chooseSkills();
            story.thirdActInto();
            enemies = randomEnemies();

            randomEvents = randomEvents();
            //restore the hp of player
            hero.hp = hero.maxHp;
        } else if (hero.xp >= 120 && act == 3) {
            act = 4;
            place = 3;
            //end of the third act
            story.thirdActOutro();
            //level up
            hero.chooseSkills();
            story.fourthActInto();
            //restore the hp of player
            hero.hp = hero.maxHp;
            //final battle(boss)
            finalBattle();
        }
    }

    private void finalBattle() {
        battle(new Enemy("Alduin", 250, 300));
        story.endStory(hero);
        runGame = false;
    }

    private void printMenu() {
        tools.clearConsole();
        tools.printHeading(places[place]);
        System.out.println("Choose an action:");
        tools.printSeparator(30);
        System.out.println("1 - Continue your trip");
        System.out.println("2 - Check hero stats");
        System.out.println("3 - Exit the game");
    }
}

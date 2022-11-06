/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex;

import com.khomsi.softServe.homework4Ex.enemies.Enemy;
import com.khomsi.softServe.homework4Ex.heroes.Player;
import com.khomsi.softServe.homework4Ex.tools.Story;
import com.khomsi.softServe.homework4Ex.tools.Tools;

public class GameLogic {
    //TODO make battle between one hero and different enemies, add buffs to enemy, like zombie
    static Tools tools = new Tools();
    static Player player;
    static Story story = new Story();
    static boolean runGame;
    //Events that can be happened during the trip
    static String[] randomEvents = {"Battle", "Battle", "Rest", "Battle", "Rest", "Shop"};

    //names for enemies
    static String[] enemies = {"Draugr", "Falmer", "Draugr Death Overlord",
            "Wolf", "Necromancer", "Skeleton"};

    static int place = 0, act = 1;
    static String[] places = {"Whiterun", "Dawnstar", "Falkreath",
            "Markarth", "Morthal", "Riften", "Sovngarde"};


    //Start the game
    public void startGame() {
        tools.clearConsole();
        tools.printSeparator(45);
        tools.printSeparator(30);
        System.out.println("SKYRIM RPG GAME");
        tools.printSeparator(30);
        tools.printSeparator(40);
        tools.pressToContinue();

        //getting the player name
        String userName = tools.getUserName();

        //Show story to user

        story.storyInto();

        player = new Player(userName);
        story.firstActInto();
        //start main game loop
        runGame = true;
        loopGame();
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
        tools.printHeading("DRAGONBORN STATS");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        tools.printSeparator(30);
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        tools.printSeparator(30);
        System.out.println("Potions left: " + player.pots);
        tools.printSeparator(30);
        if (player.numAttackBuffs > 0) {
            System.out.println("Attack buffs: "
                    + player.attackBuffs[player.numAttackBuffs - 1]);
            tools.printSeparator(20);
        }
        if (player.numDefendBuffs > 0) {
            System.out.println("Defending buffs: " +
                    player.defendBuffs[player.numDefendBuffs - 1]);
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
        int price = (int) (Math.random() * (10 + player.pots * 3) + 10 + player.pots);
        System.out.println("Magic potion: " + price + " gold");
        tools.printSeparator(30);
        System.out.println("Do you want to buy one?\n 1 - YES, YES, YES!\n2 - No, not this time");
        int input = tools.readInt("-->", 2);
        if (input == 1) {
            if (player.gold >= price) {
                tools.printHeading("You bought magic potion for " + price + " gold!");
                player.pots++;
                player.gold -= price;
            } else
                tools.printHeading("You don't have enough money! Try again later!");
            tools.pressToContinue();
        }
    }

    private void takeRest() {
        tools.clearConsole();
        if (player.restLeft >= 1) {
            tools.printHeading("Do you want to rest? (" + player.restLeft + " rest(s) left).");
            System.out.println("1 - YES, YES ,YES!\n2 - No, maybe next time.");
            int input = tools.readInt("-->", 2);
            if (input == 1) {
                tools.clearConsole();
                if (player.hp < player.maxHp) {
                    int hpRest = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                    player.hp += hpRest;
                    if (player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("You took a rest and restored " + hpRest + " health!");
                    System.out.println("Now you have " + player.hp + "|" + player.maxHp + " health!");
                    player.restLeft--;
                } else
                    System.out.println("You have a full HP. You don't need to restore it!");
                tools.pressToContinue();
            }
        }
    }

    private int increasedHeroAttack() {
        //save calculated attack
        int newDamage = player.attack();
        if (player.numAttackBuffs != 0) {
            //Change the attack damage every time hero choose new skill
            switch (player.attackBuffs[player.numAttackBuffs - 1]) {
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
        int newDefend = player.defend();
        //Change the attack damage every time hero choose new skill
        if (player.numDefendBuffs != 0) {
            switch (player.defendBuffs[player.numDefendBuffs - 1]) {
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
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }

    //Main battle method
    private void battle(Enemy enemy) {
        while (true) {
            tools.clearConsole();
            tools.printHeading(enemy.name + "\nHP: " + enemy.hp + "|" + enemy.maxHp);
            tools.printHeading(player.name + "\nHP: " + player.hp + "|" + player.maxHp);
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
                player.hp -= dmgTook;
                enemy.hp -= dmg;

                tools.clearConsole();
                tools.printHeading("BATTLE");
                System.out.println("You did " + dmg + " damage to the " + enemy.name + "!");
                tools.printSeparator(15);
                System.out.println("The " + enemy.name + " did " + dmgTook + " damage to you!");
                tools.pressToContinue();
                //check if battle is over
                //check if player is dead or no
                if (player.hp <= 0) {
                    heroDied();
                    break;
                } else if (enemy.hp <= 0) {
                    tools.clearConsole();
                    tools.printHeading("You defeated the " + enemy.name + "!");
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP!");
                    boolean newRest = (Math.random() * 5 + 1 <= 3.25);
                    int goldEarned = (int) (Math.random() * enemy.xp);
                    if (newRest) {
                        player.restLeft++;
                        System.out.println("You got extra rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You got " + goldEarned
                                + " gold in your pocket from " + enemy.name + "!");
                    }
                    tools.pressToContinue();
                    break;
                }
            } else if (input == 2) {
                tools.clearConsole();
                if (player.pots > 0 && player.hp < player.maxHp) {
                    tools.printHeading("Drink the potion? (" + player.pots + " left).");
                    System.out.println("1 - YES, YES, YES!\n 2 - No, not this time...");
                    input = tools.readInt("-->", 2);
                    if (input == 1) {
                        player.hp = player.maxHp;
                        tools.clearConsole();
                        tools.printHeading("You drank potion, your HP was restored! \nHP: " + player.hp);
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
                        if (player.hp <= 0) {
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
        tools.printHeading("You earned " + player.xp +
                " XP on your trip. Try to earn more XP next time!!");
        System.out.println("Thanks for playing!!");
        runGame = false;
    }

    //Method that changes acts, depends on xp(experience) of player
    private void checkAct() {
        if (player.xp >= 20 && act == 1) {
            act = 2;
            place = 1;
            //end of the first act
            story.firstActOutro();
            //level up
            player.chooseSkills();
            story.secondActInto();

            //TODO Generate new random enemies for next stage with random generator to avoid hardcode
            enemies[0] = "Mega Skeleton";
            enemies[1] = "Vampire1";
            enemies[2] = "Vampire2";
            enemies[3] = "Vampire3";
            enemies[4] = "Vampire4";
            enemies[5] = "Vampire5";

            randomEvents[0] = "Battle";
            randomEvents[1] = "Battle";
            randomEvents[2] = "Battle";
            randomEvents[3] = "Battle";
            randomEvents[4] = "Shop";
        } else if (player.xp >= 60 && act == 2) {
            act = 3;
            place = 2;
            //end of the second act
            story.secondActOutro();
            //level up
            player.chooseSkills();
            story.thirdActInto();
            //TODO Generate new random enemies for next stage with random generator to avoid hardcode
            enemies[0] = "Mega Skeleton2";
            enemies[1] = "Vampire12";
            enemies[2] = "Vampire22";
            enemies[3] = "Vampire32";
            enemies[4] = "Vampire42";
            enemies[5] = "Vampire52";

            randomEvents[0] = "Battle";
            randomEvents[1] = "Battle";
            randomEvents[2] = "Battle";
            randomEvents[3] = "Rest";
            randomEvents[4] = "Shop";
            //restore the hp of player
            player.hp = player.maxHp;
        } else if (player.xp >= 120 && act == 3) {
            act = 4;
            place = 3;
            //end of the third act
            story.thirdActOutro();
            //level up
            player.chooseSkills();
            story.fourthActInto();
            //restore the hp of player
            player.hp = player.maxHp;
            //final battle(boss)
            finalBattle();
        }
    }


    private void finalBattle() {
        //TODO change the name of enemy and his stats for epic battle
        battle(new Enemy("THE LAST BOSS", 300));
        story.endStory(player);
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

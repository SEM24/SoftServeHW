/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4;

import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;
import com.khomsi.softServe.homework4.enemies.TestMob;
import com.khomsi.softServe.homework4.enemies.Zombie;
import com.khomsi.softServe.homework4.heroes.Archer;
import com.khomsi.softServe.homework4.heroes.Mage;
import com.khomsi.softServe.homework4.heroes.Warrior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameTools {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean gameIsRunning;

    public void startGame() {
        cleanConsole();
        printSeparator(40);
        System.out.println("THE GAME STARTS, HAVE A NICE GAME!!!");
        printSeparator(40);
        pressToContinue();

        String name = getUserName();

        Hero hero = chooseCharacter(name);
        gameIsRunning = true;
        loopGame(hero);

    }

    private void loopGame(Hero hero) {
        List<Enemy> enemyList = new ArrayList<>();
        enemyList.add(new Zombie(120));
        enemyList.add(new TestMob(100));

        while (gameIsRunning) {
            printMenu();
            int input = readInt("-->", 3);
            if (input == 1) battleStarts(enemyList, hero);
            else if (input == 2) checkHeroStats(hero);
            else if (input == 3) gameIsRunning = false;
        }
    }

    private void battleStarts(List<Enemy> enemies, Hero hero) {
        List<Enemy> amountOfEnemies = getRandomAmountOfEnemies(enemies, 2);
        String heroInfo = hero.getClass().getSimpleName() + " " + hero.getName();

        while (true) {
            cleanConsole();
            showAllEnemies(amountOfEnemies);
            printTitle(heroInfo + "\nHP: " + hero.getHealth());
            System.out.println("Choose action:");
            printSeparator(20);
            System.out.println("1 - Fight\n2 - Run away");
            int input = readInt("-->", 2);
            if (input == 1) {
                cleanConsole();
                printTitle("BATTLE STARTS!!!");
                hero.attackEnemies(amountOfEnemies, hero);
                if (!checkIfEnemiesIsDead(amountOfEnemies)) {
                    cleanConsole();
                    printTitle("Whole enemies are dead, you won the battle!!!!");
                    pressToContinue();
                    gameIsRunning = false;
                    break;
                }
                printSeparator(20);
                System.out.println("The enemy(enemies) attacked you!");
                for (Enemy enemy : amountOfEnemies) {
                    enemy.attackHero(hero);
                }
                pressToContinue();
                if (heroIsDead(hero, heroInfo)) break;

            } else if (input == 2) {
                cleanConsole();
                //35% of chance
                if (Math.random() * 10 + 1 <= 3.5) {
                    printTitle("You ran away from the enemies!!!");
                    pressToContinue();
                    gameIsRunning = false;
                    break;
                } else {
                    printTitle("You didn't run away!\nYou got damage....");
                    hero.takeDamage(new Random().nextInt(20));
                    pressToContinue();
                    if (heroIsDead(hero, heroInfo)) break;
                }
            }
        }
    }

    private String getUserName() {
        boolean userName = false;
        String name;
        do {
            cleanConsole();
            printTitle("Print your name: ");
            name = scanner.next();
            while (!isName(name)) {
                System.err.println("Please enter a valid name!");

                name = scanner.next();
            }
            cleanConsole();
            System.out.println("The player's name is: " + name + ".\nAre you sure?");
            System.out.println("1 - YES, YES, YES!!");
            System.out.println("2 - No, change the name please.");

            int input = readInt("-->", 2);
            if (input == 1) userName = true;
        } while (!userName);
        return name;
    }

    private Hero chooseCharacter(String name) {
        Hero hero = null;

        chooseCharacterText();
        int input = readInt("-->", 3);
        if (input == 1) hero = new Mage(name);
        else if (input == 2) hero = new Warrior(name);
        else if (input == 3) hero = new Archer(name);

        System.out.println("Your hero is: " + hero.getClass().getSimpleName());
        return hero;
    }

    private boolean heroIsDead(Hero hero, String heroInfo) {
        if (!hero.isAlive()) {
            cleanConsole();
            printTitle(heroInfo + " died...\n");
            printTitle("Try again next time!");
            gameIsRunning = false;
            return true;
        }
        return false;
    }

    private boolean checkIfEnemiesIsDead(List<Enemy> enemies) {
        boolean atLeastOne = false;
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                atLeastOne = true;
            }
        }
        return atLeastOne;
    }

    private void showAllEnemies(List<Enemy> amountOfEnemies) {
        for (Enemy enemy : amountOfEnemies) {
            if (enemy.getHealth() <= 0) {
                printTitle("\n" + enemy.getClass().getSimpleName()
                        + " is dead.");
            } else if (enemy.getHealth() > 0)
                printTitle(enemy.getClass().getSimpleName() + "\nHP: " + enemy.getHealth());
        }
    }


    //    FIXME
    public List<Enemy> getRandomAmountOfEnemies(List<Enemy> list, int totalItems) {
        Random rand = new Random();

        // create a temporary list for storing
        // selected enemies
        List<Enemy> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            // take a random index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(list.size());

            // add element in temporary list
            newList.add(list.get(randomIndex));
////            FIXME
//            // Remove selected element from original list
            list.remove(randomIndex);
        }
        return newList;
    }


    private void printMenu() {
        cleanConsole();
        printTitle("MENU");
        System.out.println("Choose action:");
        printSeparator(30);
        System.out.println("1 - Start the battle.");
        printSeparator(30);
        System.out.println("2 - Check your stats.");
        printSeparator(30);
        System.out.println("3 - Exit the game.");
        printSeparator(30);

    }

    private void checkHeroStats(Hero hero) {
        cleanConsole();
        printTitle("HERO STATS");
        System.out.println(hero.getName() + "\t HP: " + hero.getHealth());
        printSeparator(30);
        System.out.println("You choosed " + hero.getClass().getSimpleName() + " character!");
        printSeparator(30);

        pressToContinue();
    }

    private void chooseCharacterText() {
        String[] heroes = {"Choose character:",
                "1 - Mage",
                "2 - Warrior",
                "3 - Archer",
        };
        for (String option : heroes) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public int readInt(String text, int selectionRange) {
        int input;
        do {
            System.out.print(text + " ");
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception ex) {
                input = -1;
                System.err.println("Please enter an integer!");
                scanner.next();
            }
        } while (input < 1 || input > selectionRange);
        return input;
    }

    public boolean isName(String s) {
        for (char c : s.toCharArray())
            if (!Character.isLetter(c)) return false;
        return true;
    }

    public void printTitle(String title) {
        printSeparator(20);
        System.out.println(title);
        printSeparator(20);
    }

    public void cleanConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public void printSeparator(int num) {
        for (int i = 0; i < num; i++)
            System.out.print("-");
        System.out.println();
    }

    public void pressToContinue() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

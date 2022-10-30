/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4;

import com.khomsi.softServe.homework4.character_type.Enemy;
import com.khomsi.softServe.homework4.character_type.Hero;

import java.util.List;
import java.util.Random;

public class Tools {
    private final Random random = new Random();
    private final GameLogic gameLogic = new GameLogic();

    //Roll different amount of damage, depends on range
    public void amountOfDamage(Enemy enemy, String className, int min, int diff) {
        System.out.println(className + " has attacked the enemy");
        enemy.takeDamage(random.nextInt(diff + 1) + min);
    }

    public void healYourSelf(Hero hero, int min, int max, double chance, Enemy enemy) {
        if (!enemy.isAlive() && (Math.random() * 10 + 1 <= chance)) {
            hero.setHealth(hero.getHealth() + random.nextInt(max - min + 1) + min);
            System.out.println("You found health spell in " + enemy.getClass().getSimpleName()
                    + "Your HP is: " + hero.getHealth());
        }
    }

    public void attackEachEnemy(List<Enemy> enemies, int min, int max, Hero hero, double chance) {
        for (Enemy enemy : enemies) {
            gameLogic.printTitle("You attacked " + enemy.getClass().getSimpleName() + "!!");
            enemy.takeDamage(random.nextInt(max - min + 1) + min);
            gameLogic.printTitle(enemy.isAlive() ? enemy.getClass().getSimpleName() +
                    " is still alive" : enemy.getClass().getSimpleName() + " is dead");
            System.out.println();
            new Tools().healYourSelf(hero, min, max, chance, enemy);
        }
    }

    public void showEnemyAttack(Hero hero, String className, double chance, int criticalDamage, int damage) {
        gameLogic.printTitle(className + "has attacked you!!");
        if (Math.random() * 10 + 1 <= chance) {
            System.out.println(className + "made a critical damage!");
            hero.takeDamage((int) (Math.random() * criticalDamage));
        } else hero.takeDamage((int) (Math.random() * damage));
        gameLogic.printTitle(hero.isAlive() ? hero.getClass().getSimpleName() +
                " is still alive" : hero.getClass().getSimpleName() + " is dead");
        System.out.println();
    }
}

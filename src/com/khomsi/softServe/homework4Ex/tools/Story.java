/*
 * Author: SEM
 */

/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex.tools;

import com.khomsi.softServe.homework4Ex.heroes.Hero;

public class Story {
    static Tools tools = new Tools();

    //TODO Add skyrim plot
    public void storyInto() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("\tSTORY");
        tools.printSeparator(30);
        System.out.println("Imperial soldiers have captured Ulfric Stormcloak and are preparing to execute him," +
                " along with the Dragonborn who was caught up in the skirmish and\nmistakenly believed to be a rebel. ");
        System.out.println("Before the hero can be executed, Alduin appears, attacking the imperial outpost" +
                " and thus rescuing the Dragonborn.");
        System.out.println("The Dragonborn escapes and warns Jarl Balgruuf of Whiterun of the dragon attack. " +
                "Now it's time to find out what is going on and\nto kill this dragon whose name is Alduin!");
        tools.pressToContinue();
        tools.clearConsole();
    }

    public void firstActInto() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT I - INTRO");
        tools.printSeparator(30);
        System.out.println("It's the first dragon seen in centuries, and it burns down nearly all of Helgen.");
        System.out.println("Only a few people manage to escape, with Ulfric Stormcloak returning to Windhelm and\n" +
                "the prisoner making their way to the nearest town, Riverwood.");
        System.out.println("In Riverwood, the Dragonborn is told that they should head to Whiterun, the capital of the Whiterun hold,\n" +
                "and report their findings to Jarl Balgruuf the Greater.");
        System.out.println("The Dragonborn starts moving to Whiterun as fast, as it possible...");
        tools.pressToContinue();
    }

    public void firstActOutro() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT I - OUTRO");
        tools.printSeparator(30);
        System.out.println("After meeting up with Jarl Balgruuf, the Dragonborn is tasked with" +
                " obtaining the Dragonstone\nfrom Bleak Falls Barrow.");
        System.out.println("Unfortunately, it's time to travel again...");
        tools.pressToContinue();
    }

    public void secondActInto() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT II - INTRO");
        tools.printSeparator(30);
        System.out.println("After returning to Jarl Balgruuf with the stone tablet, the Dragonborn learns that there's\n" +
                "a dragon attack at the Western Watchtower.");
        System.out.println("The Dragonborn started to run to that place to start the fight...");
        tools.pressToContinue();
    }

    public void secondActOutro() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT II - OUTRO");
        tools.printSeparator(30);
        System.out.println("After slaying the dragon and absorbing its soul, the Dragonborn shouts to reveal that\n" +
                "they are the Dragonborn of legend.");
        System.out.println("Once the Dragonborn returns to Jarl Balgruuf, the Jarl wastes no time naming them the Thane of Whiterun,\n" +
                "an honorary title given to someone of great importance to the city...");
        tools.pressToContinue();
    }

    public void thirdActInto() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT III - INTRO");
        tools.printSeparator(30);
        System.out.println("The Greybeards summon the Dragonborn to their home in High Hrothgar near the\n" +
                "Throat of the World, the highest point in Tamriel.");
        System.out.println("The Greybeards are masters of the Thu’um and plan to teach the Dragonborn\n" +
                "everything they know.");
        System.out.println("The Dragonborn started a long trip to High Hrothgar while facing enemies...");
        tools.pressToContinue();
    }

    public void thirdActOutro() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT III - OUTRO");
        tools.printSeparator(30);
        System.out.println("After a long journey to High Hrothgar, one of the Greybeard monks, Arngeir, lets\n" +
                "the Dragonborn know that it’s up to them to stop Alduin and restore peace to Skyrim.");

    }

    public void fourthActInto() {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT IV - INTRO");
        tools.printSeparator(30);
        System.out.println("After looooong journey, the Dragonborn got information that it's possible to find\nthe " +
                "Alduin in Sovngrade.");
        System.out.println("But there's no way for anyone to get to Sovngarde from the natural world, but Odahviing\n" +
                "offered the Dragonborn a ride to Sovngarde in exchange for his freedom.");
        System.out.println("he Dragonborn accepts the deal and makes their way to Sovngarde. There, they meet up with\n" +
                "the same three heroes from the vision in the Elder Scroll to take down Alduin.");
        tools.pressToContinue();
    }

    public void endStory(Hero hero) {
        tools.clearConsole();
        tools.printSeparator(30);
        System.out.println("ACT V - ENDING");
        tools.printSeparator(30);
        System.out.println("After a difficult fight, Alduin is slain by the Dragonborn,\n" +
                "and peace is restored to Skyrim — to an extent. ");
        System.out.println("There's no canonical ending to the Skyrim Civil War, so it's not confirmed if the Imperials\n" +
                "or the Stormcloaks are in charge of the province. Regardless, with Alduin slain, Skyrim is in a much better place.");
        System.out.println();
        System.out.println("The Dragonborn whose name is " + hero.name + " had "
                + hero.gold + " gold left and got " + hero.xp + " XP, well done DOVAKIN!\n" +
                "See you next time, when you will restarted the game ツ");
    }
}

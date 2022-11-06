/*
 * Author: SEM
 */

package com.khomsi.softServe.homework4Ex.tools;

import java.io.IOException;
import java.util.Scanner;

public class Tools {
    static Scanner scanner = new Scanner(System.in);

    //method to get input from user
    public int readInt(String message, int choice) {
        int input;
        do {
            System.out.print(message + " ");
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception o) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > choice);
        return input;
    }

    //method to clean the console
    public void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //method to print a separator with length of n
    public void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //method to print a heading
    public void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to stop the game until user press enter
    public void pressToContinue() {
        System.err.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //check whether the input is a string or not
    public boolean isName(String s) {
        for (char c : s.toCharArray())
            if (!java.lang.Character.isLetter(c)) return false;
        return true;
    }

    //Get name the name from user and validate it
    public String getUserName() {
        boolean setName = false;
        String name;
        do {
            clearConsole();
            printHeading("Print your name: ");
            name = scanner.next();
            while (!isName(name)) {
                System.err.println("Please enter a valid name!");

                name = scanner.next();
            }
            clearConsole();
            System.out.println("The player's name is: " + name + ".\nAre you sure?");
            System.out.println("1 - YES, YES, YES!!");
            System.out.println("2 - No, change the name please.");

            int input = readInt("-->", 2);
            if (input == 1) setName = true;
        } while (!setName);
        return name;
    }

}

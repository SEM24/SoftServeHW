/*
 * Author: SEM
 */

package com.khomsi.softServe.homework1;

import java.util.Scanner;

public class HryvniaTask {
    public static void main(String[] args) {
        new HryvniaTask().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int value = getInput(scanner);
        solutionOne(value);
        solutionTwo(value);
        solutionThree(scanner);
    }

    private void solutionOne(int value) {
        String currency = " грив";
        String[] ending = {"ня", "ні", "ень"};
        if (value == 1)
            System.out.println("Your input money is: " + value + (currency.concat(ending[0])));
        else if (value == 2 || value == 3 || value == 4)
            System.out.println("Your input money is: " + value + (currency.concat(ending[1])));
        else
            System.out.println("Your input money is: " + value + (currency.concat(ending[2])));
    }

    private void solutionTwo(int value) {
        System.out.println();
        //I'm using enhanced switch, so I don't need break;
        switch (value) {
            case 1 -> System.out.println("Your input money is: " + value + " гривня");
            case 2, 3, 4 -> System.out.println("Your input money is: " + value + " гривні");
            default -> System.out.println("Your input money is: " + value + " гривень");
        }
    }

    private void solutionThree(Scanner in) {
        System.out.println("\nEnter the number of hryvnia: ");
        String value = Integer.toString(in.nextInt());
        char result = value.charAt(value.length() - 1);
        if (result == '1')
            System.out.println("Your input money is: " + value + " гривня");
        else if (result == '2' || result == '3' || result == '4')
            System.out.println("Your input money is: " + value + " гривні");
        else System.out.println("Your input money is: " + value + " гривень");
    }


    /*
       Input value with checking the range of num
     */
    public int getInput(Scanner in) {
        System.out.print("Enter the number of hryvnia (between 1-10): ");
        int input;
        while (true) {
            input = in.nextInt();
            if (input >= 1 && input <= 10) {
                // Break if you got the number that match the expression.
                break;
            }
            System.out.print("Invalid input.\nEnter the number of hryvnia (between 1-10): ");
        }
        return input;
    }
}

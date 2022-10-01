/*
 * Author: SEM
 */

package com.khomsi.softServe.homework2;

import java.util.Scanner;

public class Multiplicity {
    public static void main(String[] args) {
        new Multiplicity().run();
    }

    private void run() {
        System.out.print("Solution 1");
        int min = 10;
        int max = 50;
        calculate(min, max);

        System.out.println("\n\nSolution 2");
        Scanner scanner = new Scanner(System.in);
        min = getInput(scanner);
        max = getInput(scanner);
        calculate1(min, max);
    }

    private void calculate(int min, int max) {
        System.out.println("\nDisplay all multiples of 3 in the range from " + min + " to " + max);
        for (; min <= max; min++) {
            if (min % 3 == 0) System.out.print(min + " ");
        }
    }

    private void calculate1(int min, int max) {
        System.out.println("\nDisplay all multiples of 3 in the range from " + min + " to " + max);
        while (min <= max) {
            if (min % 3 == 0) System.out.print(min + " ");
            min++;
        }
    }

    /*
    Get the number from user
    */
    private int getInput(Scanner scanner) {
        System.out.print("Print num for range: ");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.err.print("Invalid input.\nTry again: ");
            } else {
                int num = scanner.nextInt();
                if (num >= 1 && num % 10 == 0) return num;
                System.err.print("You must enter not negative number and that ends on 0.\nTry again: ");
            }
            scanner.nextLine();
        }
    }
}

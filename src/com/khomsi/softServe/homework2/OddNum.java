/*
 * Author: SEM
 */

package com.khomsi.softServe.homework2;

import java.util.Scanner;

public class OddNum {

    public static void main(String[] args) {
        new OddNum().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int num = Math.abs(getInput(scanner) * 2);
        solutionOne(num);
        solutionTwo(num);
    }

    private void solutionOne(int num) {
        int sum = 0;
        System.out.print("Odd numbers: ");
        for (int i = 1; i < num; i += 2) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\nSum of odd numbers: " + sum + "\n");
    }

    private void solutionTwo(int num) {
        int sum = 0;
        System.out.print("Odd numbers: ");
        for (int i = 1; i < num; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("\nSum of odd numbers: " + sum);
    }

    /*
   Get the number from user
 */
    private int getInput(Scanner scanner) {
        System.out.print("Print number: ");
        int num;
        while (!scanner.hasNextInt()) {
            System.err.print("That's not a number! Try again: ");
            scanner.next();
        }
        num = scanner.nextInt();
        return num;
    }
}

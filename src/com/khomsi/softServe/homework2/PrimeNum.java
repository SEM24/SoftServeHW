/*
 * Author: SEM
 */

package com.khomsi.softServe.homework2;

import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {
        new PrimeNum().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int num = getInput(scanner);

        System.out.println(solutionTwo(num) ? num + " is a prime number."
                : num + " is not a prime number.");
    }


    private boolean solutionTwo(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0 && n != 2) return false;
        //check only half of num to speed up loop and for big nums
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /*
     Get the number from user
    */
    private int getInput(Scanner scanner) {
        System.out.print("Print number: ");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.err.print("Invalid input.\nTry again: ");
            } else {
                int num = scanner.nextInt();
                if (num >= 1) return num;
                System.err.print("You must enter not negative number.\nTry again: ");
            }
            scanner.nextLine();
        }
    }
}
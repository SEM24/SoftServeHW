/*
 * Author: SEM
 */

package com.khomsi.softServe.homework2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        new Fibonacci().run();
    }

    private void run() {
//        System.out.print("Main task");
//        massiveFibonacci(20);
        System.out.println("\nFirst solution");
        int num = getInput(new Scanner(System.in));
        massiveFibonacci(num);
        System.out.println("\nSecond solution");
        usualFibonacci(num);
        //recursive solution doesn't fit the task and is bad practice for big nums
    }

    private void massiveFibonacci(int num) {
        long start = System.nanoTime();
        int[] nums = new int[num];
        nums[0] = 1;
        nums[1] = 1;
        float average = 0;
        for (int i = 2; i < nums.length; ++i) {
            nums[i] = nums[i - 1] + nums[i - 2];
            average += nums[i];
        }
        System.out.println("\nThe first " + num + " Fibonacci numbers are: ");
        for (Integer number : nums) {
            System.out.print(number + " ");
        }
        System.out.printf("\nAverage of numbers: " + "%.2f", (average / num));
        System.out.println("\nLead time: " + (System.nanoTime() - start) + " ns");
    }

    private void usualFibonacci(int num) {
        long start = System.nanoTime();
        int previous = 0;
        int current = 1;
        int result;
        float average = 0;
        System.out.println("\nThe first " + num + " Fibonacci numbers are: ");
        for (int i = 1; i < num; i++) {
            result = previous + current;
            System.out.print(result + " ");
            previous = current;
            current = result;
            average += result;
        }
        System.out.printf("\nAverage of numbers: " + "%.2f", (average / num));
        System.out.println("\nLead time: " + (System.nanoTime() - start) + " ns");
    }

    /*
     Get the number from user
    */
    private int getInput(Scanner scanner) {
        System.out.print("Print fibonacci series element number: ");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.err.print("Invalid input.\nTry again: ");
            } else {
                int num = scanner.nextInt();
                if (num > 0 && num != 1) return num;
                if (num == 1) System.err.print("Fibonacci of 1 is 1.\nTry again: ");
            }
            scanner.nextLine();
        }
    }
}

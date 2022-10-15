/*
 * Author: SEM
 */

package com.khomsi.softServe.homework3;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        new Task1().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Print size of array: ");
        int size = checkInput(scanner);
        System.out.print("Print range of generated nums: ");
        int range = checkInput(scanner);

        int[] values = createArray(size, range);

//        int[] values = {1, 0, 2, 5, 6, 4, 10, 3};

        int index_min = 0, index_max = 0, result = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[index_min] > values[i]) {
                index_min = i;
            }
            if (values[index_max] < values[i]) {
                index_max = i;
            }
        }
        System.out.println("\nIndex of min element is " + index_min);
        System.out.println("Index of max element is " + index_max);

        calculateSum(values, index_min, index_max, result);
    }


    private void calculateSum(int[] values, int index_min, int index_max, int result) {
        for (int i = Math.min(index_max, index_min) + 1; i < Math.max(index_max, index_min); i++) {
            result += values[i];
        }
        System.out.println("Sum of elements between indexes " + index_min +
                " and " + index_max + " is " + result);
    }

    private int[] createArray(int size, int range) {
        int[] randomNumbers = new int[size];
        Random rand = new Random();
        range++;
        for (int i = 0; i < randomNumbers.length; i++) {
            int n = rand.nextInt(range);
            randomNumbers[i] = n;
        }
        System.out.println("\nCreated array: ");
        for (int numbers : randomNumbers) {
            System.out.print(numbers + " ");
        }
        return randomNumbers;
    }

    private int checkInput(Scanner scanner) {
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

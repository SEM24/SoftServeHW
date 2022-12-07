/*
 * Author: SEM
 */

package com.khomsi.softServe.homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {
        new Task1().run();
    }

    private void run() {
        List<Integer> list = new ArrayList<>();
        int num = (int) (Math.random() * 50) + 1;
        System.out.println("\nRandom range: " + num);

        System.out.print("List of whole numbers: ");
        for (int i = 0; i <= num; i++) {
            if (i >= 1) {
                list.add(i);
                System.out.print(i + " ");
            }
        }
        mainMethod(list);
        System.out.println("\nTest method\n");
        testMethod(list);
    }

    private void mainMethod(List<Integer> list) {
        Predicate<Integer> oddFunc = n -> n % 2 != 0 && n % 5 == 0;
        double oddSum = list.stream().filter(oddFunc).mapToDouble(a -> a).average().getAsDouble();
        System.out.println("\nAverage of numbers that are odd and divided on 5: " + oddSum);
    }

    private void testMethod(List<Integer> list) {
        int sum1 = 0;
        int counter = 0;
        for (Integer integer : list) {
            if (integer % 2 != 0 && integer % 5 == 0) {
                sum1 += integer;
                counter++;
            }
        }
        System.out.println("\nSum of odd and divided on 5 nums:" + sum1);
        System.out.println("\nAverage of numbers that are odd and divided on 5: " + (double) (sum1 / counter));
    }
}

/*
 * Author: SEM
 */

package com.khomsi.softServe.homework3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        new Task3().run();
    }

    private void run() {
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{6, 7};
        printArr(firstSolution(array1, array2));
        secondSolution(array1, array2);
    }

    private int[] firstSolution(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        for (int i = 0; i < result.length; i++) {
            if (i < arr1.length) result[i] = arr1[i];
            else result[i] = arr2[i - arr1.length];
        }
        return result;
    }

    private void secondSolution(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        arr1 = Arrays.copyOf(arr1, size1 + size2);
        System.arraycopy(arr2, 0, arr1, size1, size2);
        System.out.println("\n" + Arrays.toString(arr1).replaceAll("^\\[|\\]$", ""));
    }

    private void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j);
        }
    }
}

/*
 * Author: SEM
 */

package com.khomsi.softServe.homework3;

public class Task2 {
    public static void main(String[] args) {
        new Task2().run();
    }

    private void run() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        printArr(secondSolution(arr));
//        printArr(firstSolution(arr));
        System.out.println("\n");
        printArr(thirdSolution(arr));

    }

//    private int[] firstSolution(int[] arr) {
//        int size = arr.length;
//        int step = arr.length - 1;
//        int temp;
//        for (int i = 0, j; i < step; ++i) {
//            temp = arr[0];
//            for (j = 0; j < size - 1; ++j)
//                arr[j] = arr[j + 1];
//            arr[j] = temp;
//        }
//        return arr;
//    }

    private int[] thirdSolution(int[] arr) {
        if (arr.length > 1) {
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 1; i != 0; i--) arr[i] = arr[i - 1];
            arr[0] = temp;
        }
        return arr;
    }

    private int[] secondSolution(int[] a) {
        int step = 1;
        int[] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (i + step >= a.length) {
                result[i + step - a.length] = a[i];
            } else {
                result[i + step] = a[i];
            }
        }
        return result;
    }

    private void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}



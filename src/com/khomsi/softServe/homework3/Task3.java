/*
 * Author: SEM
 */

package com.khomsi.softServe.homework3;

public class Task3 {
    public static void main(String[] args) {
        new Task3().run();
    }

    private void run() {
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{5, 6, 7};
        int[] result = new int[array1.length + array2.length];

        for (int index_array1 = 0, index_array2 = 0; index_array1 + index_array2 < result.length; ) {
            if (index_array1 < array1.length) result[index_array1 + index_array2] = array1[index_array1++];
            if (index_array2 < array2.length) result[index_array1 + index_array2] = array2[index_array2++];
        }
        printArr(result);
//        printArr(firstSolution(array1, array2));
//        secondSolution(array1, array2);
    }

    //FIXME если я правильно понял суть задания (если смотреть на пример), нужно делать слияние
    // и при этом так, чтобы позиции сохранялись
    // для каждого массива (чередуем два массива), поэтому нижние коды не подходит
//    private int[] firstSolution(int[] arr1, int[] arr2) {
//        int[] result = new int[arr1.length + arr2.length];
//
//        for (int i = 0; i < result.length; i++) {
//            if (i < arr1.length) result[i] = arr1[i];
//            else result[i] = arr2[i - arr1.length];
//        }
//        return result;
//    }
//
//    private void secondSolution(int[] arr1, int[] arr2) {
//        int size1 = arr1.length;
//        int size2 = arr2.length;
//        arr1 = Arrays.copyOf(arr1, size1 + size2);
//        System.arraycopy(arr2, 0, arr1, size1, size2);
//        System.out.println("\n" + Arrays.toString(arr1).replaceAll("^\\[|\\]$", ""));
//    }

    private void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

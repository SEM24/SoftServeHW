/*
 * Author: SEM
 */

package com.khomsi.softServe.homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        new Task4().run();
    }

    private void run() {
        List<Integer> array = new ArrayList<>(Arrays.asList(5, 2, 4, 2, 1));
        System.out.println(array);
        System.out.println(array.stream().map(String::valueOf)
                .collect(Collectors.joining("")));
//        String str = array.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}

/*
 * Author: SEM
 */

package com.khomsi.softServe.homework5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        new Task3().run();
    }

    private void run() {
        Map<String, Integer> map = new HashMap<>();
        map.put("122212123", 1);
        map.put("1231334", 2);
        map.put("135", 3);
        mainMethod(map);
        System.out.println("Test");
        testMethod(map);
    }

    private void mainMethod(Map<String, Integer> map) {
        int result = map.entrySet().stream()
                .filter(e -> e.getKey().length() >= 7)
                .map(Map.Entry::getValue).mapToInt(e -> e).sum();

        System.out.println("Sum: " + result);
    }

    private void testMethod(Map<String, Integer> map) {
        int sum = 0;
        Set<Map.Entry<String, Integer>> s = map.entrySet();
        for (Map.Entry<String, Integer> it : s) {
            if (it.getKey().length() >= 7) {
                sum += it.getValue();
            }
        }
        System.out.println("Sum: " + sum);
    }
}

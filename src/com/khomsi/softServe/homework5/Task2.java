/*
 * Author: SEM
 */

package com.khomsi.softServe.homework5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        new Task2().run();
    }

    private void run() {
        List<String> list = new ArrayList<>();
        int uniqueSize = 60;
        list.add("Що є свобода? Добро в ній якеє?");
        list.add("Що є свобода? Добро в ній якеє?");
        list.add("Кажуть, неначе воно золотеє?");
        list.add("Ні ж бо, не злотне: зрівнявши все злото,");
        list.add("Проти свободи воно лиш болото.");
        list.add("О, якби в дурні мені не пошитись,");
        list.add("Щоб без свободи не міг я лишитись.");
        list.add("Слава навіки буде з тобою,");
        list.add("Слава навіки буде з тобою,");
        list.add("Вольності отче, Богдане-герою!");
        list.forEach(System.out::println);
        System.out.println();
        mainMethod(list, uniqueSize);
        System.out.println();
        test1(list, uniqueSize);
        test2(list, uniqueSize);
    }

    private void mainMethod(List<String> list, int uniqueSize) {
        Set<String> newList = list.stream()
                .filter(n -> n.length() > uniqueSize).collect(Collectors.toSet());
        System.out.println("Quantity of unique lines: " + newList.size());
    }

    private void test1(List<String> list, int uniqueSize) {
        List<String> result = new ArrayList<>();
        for (String line : list) {
            if (!result.contains(line) && line.length() > uniqueSize) {
                result.add(line);
            }
        }
        System.out.println("Quantity of unique lines: " + result.size());
    }

    private void test2(List<String> list, int uniqueSize) {
        Set<String> result = new HashSet<>();
        for (String line : list) {
            if (line.length() > uniqueSize)
                result.add(line);
        }
        System.out.println("Quantity of unique lines: " + result.size());
    }
}

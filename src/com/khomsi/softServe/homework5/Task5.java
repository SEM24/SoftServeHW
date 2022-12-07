/*
 * Author: SEM
 */

package com.khomsi.softServe.homework5;

import java.util.function.Predicate;

public class Task5 {
    public static void main(String[] args) {
        Person person1 = new Person("Samir", "Khomsi Kak", 19);
        Person person2 = new Person("Dima", "Prydkiy", 30);
        Predicate<Integer> oddFunc = n -> n % 2 != 0 && n % 5 == 0;
    }
}

class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

/*
 * Author: SEM
 */

package com.khomsi.softServe.homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        Person person1 = new Person("Samir", "Khomsi Kak", 19);
        Person person2 = new Person("Dima", "Dzyr", 30);
        List<Person> array = new ArrayList<>(Arrays.asList(person1, person2));
        String res = array.stream()
                .filter(n -> (n.getFirstName() + " " + n.getLastName()).length() < 15)
                .max(Comparator.comparing(Person::getAge))
                .get().getFullName();
        if (!res.isEmpty()) System.out.println(res);
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

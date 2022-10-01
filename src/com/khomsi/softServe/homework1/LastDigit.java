/*
 * Author: SEM
 */

package com.khomsi.softServe.homework1;

import java.util.Scanner;

public class LastDigit {

    public static void main(String[] args) {
        new LastDigit().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int num = getInput(scanner);
        calculateDigit1(num);
        calculateDigit2(num);
        calculateDigit3(num);
    }

    /*
       First solution
     */
    private void calculateDigit1(int num) {
        boolean result = num % 10 == 3;
        System.out.println(result ? "The last digit of number " + num + " is 3"
                : "The last digit of number " + num + " isn't 3");
    }

    /*
       Second solution
     */
    private void calculateDigit2(int num) {
        int result = num % 10;
        System.out.println(result == 3 ? "The last digit is " + result + " that fits our task"
                : "The last digit is " + result + " that doesn't fit our task");
    }

    /*
       Third solution
     */
    private void calculateDigit3(int num) {
        String number = Integer.toString(num);
        char result = number.charAt(number.length() - 1);
        System.out.println("The last digit is " + result);
    }

    /*
       Get the number from user
     */
    private int getInput(Scanner scanner) {
        System.out.print("Print number: ");
        int num;
        while (!scanner.hasNextInt()) {
            System.out.print("That's not a number! Try again: ");
            scanner.next();
        }
        num = scanner.nextInt();
        return num;
    }
}

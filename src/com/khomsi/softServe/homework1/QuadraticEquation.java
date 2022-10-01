/*
 * Author: SEM
 */
package com.khomsi.softServe.homework1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        new QuadraticEquation().run();
    }


    private void run() {
        System.out.println("Calculate quadratic equation" +
                "\nExample: ax^2 + bx + c = 0");
        getInput();
    }

    /*
        Method that receive input values and shows output message.
     */
    private void getInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Print a: ");
            double a = scanner.nextDouble();
            System.out.print("Print b: ");
            double b = scanner.nextDouble();
            System.out.print("Print c: ");
            double c = scanner.nextDouble();

            double discriminant = discriminant(a, b, c);
            System.out.println(calculateRoots(discriminant, a, b));

        } catch (InputMismatchException e) {
            // One of the inputs was not a double
            System.err.println("Input value is not a number.");
        }
    }

    /*
       Method that calculates typical quadratic equation with the discriminant formula.
     */
    private String calculateRoots(double discriminant, double a, double b) {
        try {
            DecimalFormat df = new DecimalFormat("###.###");
            double x1, x2;
            if (discriminant == 0) {
                x1 = -b / (2 * a);
                return "The equation has two equal roots: " + df.format(x1);
            } else if (discriminant > 0) {
                x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return "The equation has two different roots: "
                        + df.format(x1) + " , " + df.format(x2);
            } else return "The equation has no real roots";
        } catch (ArithmeticException e) {
            return e.getCause().getMessage();
        }
    }

    private double discriminant(double a, double b, double c) {
        return (Math.pow(b, 2) - 4 * a * c);
    }
}

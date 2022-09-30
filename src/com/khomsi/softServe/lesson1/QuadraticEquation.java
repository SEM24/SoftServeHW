/*
 * Author: SEM
 */
package com.khomsi.softServe.lesson1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        new QuadraticEquation().run();
    }

    /*
        This method receive input values and shows output message.
     */
    private void run() {
        double a, b, c;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Print a: ");
            a = scanner.nextDouble();
            System.out.print("Print b: ");
            b = scanner.nextDouble();
            System.out.print("Print c: ");
            c = scanner.nextDouble();
            double D = 0, x = 0, x1 = 0, x2 = 0;
            calculateQuadratic(D, a, b, c, x, x1, x2);

        } catch (InputMismatchException e) {
            // One of the inputs was not a double
            System.err.println("Input value is not a number.");
        }

    }

    /*
       This method calculates typical quadratic equation with the discriminant formula.
     */
    private void calculateQuadratic(double D, double a, double b, double c,
                                    double x, double x1, double x2) {
        try {
            D = (Math.pow(b, 2) - 4 * a * c);
            DecimalFormat df = new DecimalFormat("###.###");
            if (D == 0) {
                x = -b / (2 * a);
                System.out.println("The equation has two equal roots: " + df.format(x));
            } else if (D > 0) {
                x1 = (-b + Math.sqrt(D)) / (2 * a);
                x2 = (-b - Math.sqrt(D)) / (2 * a);
                System.out.println("The equation has two different roots: "
                        + df.format(x1) + " , " + df.format(x2));
            } else System.out.println("The equation has no real roots");
        } catch (ArithmeticException e) {
            System.err.println(e.getCause().getMessage());
        }

    }
}

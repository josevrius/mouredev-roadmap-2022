package org.jvrb.roadmap2022.exercise14;

import java.math.BigInteger;
import java.util.Scanner;

public class App {

    private static final String HEADER = """
            
            CALCULAR FACTORIAL
            ==================
            Número ...:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            int number = new Scanner(System.in).nextInt();
            BigInteger factorial = calculateFactorial(number);
            System.out.println("Factorial : " + factorial);
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    // WARNING: Una recursión profunda causa "StackOverflowError"
    private static BigInteger calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative number not allowed");
        } else if (number <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(number).multiply(calculateFactorial(number - 1));
    }
}

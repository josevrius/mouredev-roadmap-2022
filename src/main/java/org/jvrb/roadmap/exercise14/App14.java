package org.jvrb.roadmap.exercise14;

import java.math.BigInteger;
import java.util.Scanner;

public class App14 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CALCULAR FACTORIAL
            ==================
            Número ...:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            int number = SCN.nextInt();
            BigInteger factorial = calculateFactorial(number);
            System.out.println("Factorial : " + factorial);
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    // WARNING: Una recursión profunda causa "StackOverflowError"
    private static BigInteger calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("No se permiten valores negativos");
        } else if (number <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(number).multiply(calculateFactorial(number - 1));
    }
}

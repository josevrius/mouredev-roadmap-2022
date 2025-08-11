package org.jvrb.roadmap.exercise15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App15 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            COMPROBAR ARMSTRONG
            ===================
            Número ...:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            int number = enterNumber();
            System.out.println("Armstrong : " + (isArmstrong(number) ? "SI" : "NO"));
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    private static int enterNumber() {
        if (!SCN.hasNextInt()) {
            throw new InputMismatchException("No es un número entero");
        }
        int number = SCN.nextInt();

        if (number < 0) {
            throw new IllegalArgumentException("No se permiten números negativos");
        }
        return number;
    }


    private static boolean isArmstrong(int number) {
        long sum = 0;
        int aux = number;
        int exponent = countDigits(number);

        while (aux != 0) {
            int base = aux % 10;
            sum += calculatePow(base, exponent);
            aux /= 10;
            if (sum > number) {
                return false;
            }
        }
        return sum == number;
    }

    private static int countDigits(int number) {
        int counter = 0;

        do {
            number /= 10;
            counter++;
        } while (number > 0);

        return counter;
    }

    private static long calculatePow(int base, int exponent) {
        long result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
}

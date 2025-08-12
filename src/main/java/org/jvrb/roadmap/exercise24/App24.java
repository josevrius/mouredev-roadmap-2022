package org.jvrb.roadmap.exercise24;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App24 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CALCULAR MCD / MCM
            ==================
            [1] Máximo Común Divisor
            [2] Mínimo Común Múltiplo
            
            Opción ..:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String option = enterOption();
            long n1 = enterNumber("Número 1 : ");
            long n2 = enterNumber("Número 2 : ");
            printResult(option, n1, n2);
        } catch (Exception e) {
            System.out.println("Error ...: " + e.getMessage());
        }
    }

    private static String enterOption() {
        String option = SCN.nextLine().strip();

        if (option.isEmpty() || !option.matches("[12]")) {
            throw new InputMismatchException("Opción incorrecta");
        }
        return option;
    }

    private static long enterNumber(String msg) {
        System.out.print(msg);

        if (!SCN.hasNextLong()) {
            throw new InputMismatchException("No es un número entero");
        }
        return SCN.nextLong();
    }

    private static long calculateGCD(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long calculateLCM(long a, long b) {
        long gcd = calculateGCD(a, b);
        if (gcd == 0) {
            return 0;
        }
        return Math.abs((a / gcd) * b);
    }

    private static void printResult(String option, long n1, long n2) {
        if (option.equals("1")) {
            System.out.println("MCD .....: " + calculateGCD(n1, n2));
        } else {
            System.out.println("MCM .....: " + calculateLCM(n1, n2));
        }
    }
}

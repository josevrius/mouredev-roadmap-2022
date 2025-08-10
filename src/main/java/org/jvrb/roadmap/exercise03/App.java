package org.jvrb.roadmap.exercise03;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            SUCESIÓN DE FIBONACCI
            =====================
            Longitud :\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            int length = enterLength();
            printFibonacciSequence(length);
        } catch (Exception e) {
            System.out.println("Error ...: " + e.getMessage());
        }
    }

    private static int enterLength() {
        if (!SCN.hasNextInt()) {
            throw new InputMismatchException("No es un número entero");
        }
        int length = SCN.nextInt();

        if (length == 0) {
            throw new IllegalArgumentException("No se permite valor cero");
        }
        if (length < 0) {
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
        return length;
    }

    private static void printFibonacciSequence(int length) {
        BigInteger[] sequence = new BigInteger[length];
        sequence[0] = BigInteger.ZERO;
        if (length > 1) {
            sequence[1] = BigInteger.ONE;
        }
        for (int i = 2; i < length; i++) {
            sequence[i] = sequence[i - 1].add(sequence[i - 2]);
        }
        System.out.println("---------------------");
        for (BigInteger number : sequence) {
            System.out.println(number);
        }
    }
}

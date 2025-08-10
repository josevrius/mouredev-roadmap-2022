package org.jvrb.roadmap.exercise09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            DECIMAL A BINARIO
            =================
            Decimal :\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            int number = enterNumber();
            System.out.println("Binario : " + convertDecimalToBinary(number));
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static int enterNumber() {
        if (!SCN.hasNextInt()) {
            throw new InputMismatchException("Entrada incorrecta");
        }
        int number = SCN.nextInt();

        if (number < 0) {
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
        return number;
    }

    private static String convertDecimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        int module = decimal;

        do {
            int remainder = module % 2;
            binary.append(remainder);
            module = module / 2;
        } while (module != 0);

        return binary.reverse().toString();
    }
}

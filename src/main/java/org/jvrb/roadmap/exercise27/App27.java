package org.jvrb.roadmap.exercise27;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App27 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            DIBUJAR POLÍGONO
            ================
            [1] Cuadrado
            [2] Triangulo
            """;

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            String option = enterOption();
            int size = enterSize();
            System.out.println();
            drawPolygon(option, size);
        } catch (Exception e) {
            System.out.println("Error .: " + e.getMessage());
        }
    }

    private static String enterOption() {
        Pattern validOptions = Pattern.compile("[1-2]");

        System.out.print("Opción : ");
        String option = SCN.nextLine();

        if (option.isEmpty()) {
            throw new InputMismatchException("Campo vacío");
        }
        if (!validOptions.matcher(option).matches()) {
            throw new InputMismatchException("Opción incorrecta");
        }
        return option;
    }

    private static int enterSize() {
        Pattern validSizes = Pattern.compile("[2-9]|10");

        System.out.print("Tamaño : ");
        String size = SCN.nextLine();

        if (size.isEmpty()) {
            throw new InputMismatchException("Campo vacío");
        }
        if (!validSizes.matcher(size).matches()) {
            throw new InputMismatchException("Tamaño fuera de rango [2, 10]");
        }
        return Integer.parseInt(size);
    }

    private static void drawPolygon(String option, int size) {
        switch (option) {
            case "1" -> drawSquare(size);
            case "2" -> drawTriangle(size);
        }
    }

    private static void drawSquare(int size) {
        System.out.println("*  ".repeat(size - 1) + '*');
        for (int i = 1; i <= size - 2; i++) {
            System.out.println("*  " + "   ".repeat(size - 2) + '*');
        }
        System.out.println("*  ".repeat(size - 1) + '*');
    }

    private static void drawTriangle(int size) {
        for (int i = 1; i < size; i++) {
            System.out.print("  ".repeat(size - i));
            if (i == 1) {
                System.out.println('*');
            } else {
                System.out.print('*');
                System.out.print("   ".repeat(i - 1));
                System.out.print(" ".repeat(i - 2));
                System.out.println('*');
            }
        }
        System.out.println("*   ".repeat(size - 1) + '*');
    }
}

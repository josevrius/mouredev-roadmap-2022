package roadmap.challenge27;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            DIBUJAR POLÍGONO
            ================
            [1] Cuadrado
            [2] Triangulo
            """;

    public static void main(String[] args) {
        try {
            System.out.println(HEADER);
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
        for (int row = 1; row <= size - 2; row++) {
            System.out.println("*  " + "   ".repeat(size - 2) + '*');
        }
        System.out.println("*  ".repeat(size - 1) + '*');
    }

    private static void drawTriangle(int size) {
        for (int row = 1; row < size; row++) {
            System.out.print("  ".repeat(size - row));
            if (row == 1) {
                System.out.println('*');
            } else {
                System.out.print('*');
                System.out.print("   ".repeat(row - 1));
                System.out.print(" ".repeat(row - 2));
                System.out.println('*');
            }
        }
        System.out.println("*   ".repeat(size - 1) + '*');
    }
}

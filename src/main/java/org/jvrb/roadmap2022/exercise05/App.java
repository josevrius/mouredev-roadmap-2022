package org.jvrb.roadmap2022.exercise05;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CALCULAR AREA POLÍGONO
            ======================
            [T] Triángulo
            [C] Cuadrado
            [R] Rectángulo
            ----------------------
            Polígono :\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String polygon = enterPolygon();
            double base = enterValue("Base ....: ");
            double height = polygon.equals("C") ? base : enterValue("Altura ..: ");
            double area = calculateArea(polygon, base, height);
            System.out.println("Area ....: " + new DecimalFormat("#.##").format(area));
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Error ...: Incorrect input");
            } else {
                System.out.println("Error ...: " + e.getMessage());
            }
        }
    }

    private static String enterPolygon() {
        String polygon = SCN.nextLine().strip().toUpperCase();

        if (polygon.isEmpty()) {
            throw new IllegalArgumentException("Empty selection");
        }
        if (!polygon.matches("[TCR]")) {
            throw new IllegalArgumentException("Invalid selection");
        }
        return polygon;
    }

    private static double enterValue(String msg) {
        System.out.print(msg);
        double base = SCN.nextDouble();

        if (base < 0) {
            throw new IllegalArgumentException("Negative number not allowed");
        }
        return base;
    }

    private static double calculateArea(String polygon, double base, double height) {
        double area;

        if (polygon.equals("T")) {
            area = base * height / 2;
        } else {
            area = base * height;
        }
        return area;
    }
}

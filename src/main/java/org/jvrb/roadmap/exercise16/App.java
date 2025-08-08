package org.jvrb.roadmap.exercise16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CONTADOR DE DÍAS
            ================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            String date = enterDate(1);
            String anotherDate = enterDate(2);
            System.out.println("Días ...: " + getDaysBetween(date, anotherDate));
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static String enterDate(int i) {
        System.out.printf("Fecha %d : ", i);
        String date = SCN.nextLine().strip();

        if (date.isEmpty()) {
            throw new IllegalArgumentException("Empty Date");
        }
        String validPattern = "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}";
        if (!date.matches(validPattern)) {
            throw new IllegalArgumentException("Invalid date pattern");
        }
        return date;
    }

    private static long getDaysBetween(String date, String anotherDate) {
        int[] rd1 = restructure(date);
        LocalDate ld1 = LocalDate.of(rd1[0], rd1[1], rd1[2]);

        int[] rd2 = restructure(anotherDate);
        LocalDate ld2 = LocalDate.of(rd2[0], rd2[1], rd2[2]);

        return Math.abs(ChronoUnit.DAYS.between(ld1, ld2));
    }

    private static int[] restructure(String date) {
        int d = Integer.parseInt(date.substring(0, 2));
        int m = Integer.parseInt(date.substring(3, 5));
        int y = Integer.parseInt(date.substring(6, 10));

        return new int[]{y, m, d};
    }
}

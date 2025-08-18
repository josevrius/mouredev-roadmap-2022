package org.jvrb.roadmap.exercise41;

import java.util.ArrayList;
import java.util.List;

public final class App41 {

    private static final String HEADER = """
            
            TRIÁNGULO DE PASCAL
            ===================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        printPascalTriangle(32);
    }

    private static void printPascalTriangle(int size) {
        List<Integer> lastRow = new ArrayList<>();
        List<Integer> currentRow = new ArrayList<>();

        for (int row = 1; row <= size; row++) {
            System.out.print(" ".repeat((size - row) * 5));
            currentRow.clear();

            for (int col = 1; col <= row; col++) {
                int number;
                if (col == 1 || col == row) {
                    number = 1;
                } else {
                    number = lastRow.get(col - 2) + lastRow.get(col - 1);
                }
                currentRow.add(number);

                if (col == 1) {
                    System.out.printf("\u001B[32m%d\u001B[0m", number);
                } else {
                    if (number % 2 == 0) {
                        System.out.printf("\u001B[31m%10d\u001B[0m", number);
                    } else {
                        System.out.printf("\u001B[32m%10d\u001B[0m", number);
                    }
                }
            }
            System.out.println();
            lastRow = List.copyOf(currentRow); // Copia inmutable
        }
    }
}

package org.jvrb.roadmap.exercise25;

import java.util.stream.IntStream;

public class App25 {

    private static final String HEADER = """
            
            CONTANDO DEL 1 AL 10
            ====================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        count1();
        count2();
        count3();
        count4();
        count5(1);
        count6();
    }

    // Bucle for
    private static void count1() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            System.out.print(i < 10 ? " " : System.lineSeparator());
        }
    }

    // Bucle do-while
    private static void count2() {
        int i = 1;

        do {
            System.out.print(i);
            System.out.print(i < 10 ? " " : System.lineSeparator());
            i++;
        } while (i <= 10);
    }

    // Bucle while
    private static void count3() {
        int i = 1;

        while (i <= 10) {
            System.out.print(i);
            System.out.print(i < 10 ? " " : System.lineSeparator());
            i++;
        }
    }

    // Iteración array
    private static void count4() {
        int[] counter = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : counter) {
            System.out.print(i);
            System.out.print(i < 10 ? " " : System.lineSeparator());
        }
    }

    // Recursividad
    private static void count5(int i) {
        if (i <= 10) {
            System.out.print(i);
            System.out.print(i < 10 ? " " : System.lineSeparator());
            count5(i + 1);
        }
    }

    // Stream
    private static void count6() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            System.out.print(i);
            System.out.print(i < 10 ? " " : System.lineSeparator());
        });
    }
}

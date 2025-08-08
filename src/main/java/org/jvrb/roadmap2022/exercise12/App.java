package org.jvrb.roadmap2022.exercise12;

import java.util.Scanner;

public class App {

    private static final String HEADER = """
            
            ELIMINANDO CARACTERES
            =====================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            String text1 = enterText(1);
            String text2 = enterText(2);
            printNoCommon(text1, text2);
        } catch (Exception e) {
            System.out.println("Error ...: " + e.getMessage());
        }
    }

    private static String enterText(int i) {
        System.out.printf("Texto %d .: ", i);
        String text = new Scanner(System.in).nextLine().strip();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Empty text");
        }
        return text;
    }

    private static void printNoCommon(String text1, String text2) {
        StringBuilder out1 = new StringBuilder();
        StringBuilder out2 = new StringBuilder();

        getNoCommon(text1.toUpperCase(), text2.toUpperCase(), out1);
        getNoCommon(text2.toUpperCase(), text1.toUpperCase(), out2);

        System.out.println("Output 1 : " + out1.toString().strip());
        System.out.println("Output 2 : " + out2.toString().strip());
    }

    private static void getNoCommon(String text1, String text2, StringBuilder out) {
        for (int i = 0; i < text1.length(); i++) {
            char c = text1.charAt(i);
            if (text2.indexOf(c) == -1 && out.indexOf(String.valueOf(c)) == -1) {
                out.append(c).append(' ');
            }
        }
    }
}

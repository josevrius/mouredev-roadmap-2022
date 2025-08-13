package org.jvrb.roadmap.exercise31;

import java.util.Scanner;

public final class App31 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            MARCO DE PALABRAS
            =================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            String text = enterText();
            printFramed(text);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static String enterText() {
        System.out.print("Texto : ");
        String text = SCN.nextLine();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Texto vacío");
        }
        return text;
    }

    private static void printFramed(String text) {
        String[] words = text.strip().split("\\s+");
        int maxWordLength = 0;

        for (String word : words) {
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }
        System.out.println();
        System.out.println("*".repeat(maxWordLength + 4));
        for (String word : words) {
            System.out.println("* " + word + " ".repeat(maxWordLength - word.length()) + " *");
        }
        System.out.println("*".repeat(maxWordLength + 4));
    }
}

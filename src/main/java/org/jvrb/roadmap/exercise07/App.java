package org.jvrb.roadmap.exercise07;

import java.util.Scanner;

public class App {

    private static final String HEADER = """
            
            CADENAS INVERTIDAS
            ==================
            Texto ....:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String text = enterText();
            reverse(text);
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = new Scanner(System.in).nextLine();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Entrada nula");
        }
        return text;
    }

    private static void reverse(String text) {
        if (text != null && !text.isEmpty()) {
            StringBuilder reversed = new StringBuilder();

            for (int i = text.length() - 1; i >= 0; i--) {
                char c = text.charAt(i);
                reversed.append(c);
            }
            System.out.println("Invertido : " + reversed);
        }
    }
}

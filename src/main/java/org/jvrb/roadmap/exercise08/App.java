package org.jvrb.roadmap.exercise08;

import java.util.HashMap;
import java.util.Scanner;

public class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            PALABRAS REPETIDAS
            ==================
            Texto :\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String text = enterText();
            countRepeatedWords(text);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = SCN.nextLine();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Entrada nula");
        }
        return text;
    }

    private static void countRepeatedWords(String text) {
        if (text != null && !text.isEmpty()) {
            HashMap<String, Integer> map = new HashMap<>();
            String[] words = text.toLowerCase().split("[^a-záéíóúü]+");

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            System.out.println("------------------");
            map.forEach((word, counter) -> System.out.printf("%s : %d\n", word, counter));
        }
    }
}

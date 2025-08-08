package org.jvrb.roadmap.exercise02;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            COMPROBAR ANAGRAMAS
            ===================""";

    public static void main(String[] args) {
        System.out.println(HEADER);

        try {
            String word1 = enterWord(1);
            String word2 = enterWord(2);
            boolean result = areAnagrams(word1, word2);
            System.out.printf("Anagramas : %s%n", result ? "SI" : "NO");
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    private static String enterWord(int i) {
        System.out.printf("Palabra %d : ", i);
        String word = SCN.nextLine().strip();

        if (word.isEmpty()) {
            throw new InputMismatchException("empty input");
        }
        if (word.contains(" ")) {
            throw new InputMismatchException("only a word allowed");
        }
        return word;
    }

    private static boolean areAnagrams(String word1, String word2) {
        boolean result = false;

        if (!word1.equals(word2)) {
            char[] word1Chars = normalize(word1).toCharArray();
            char[] word2Chars = normalize(word2).toCharArray();
            Arrays.sort(word1Chars);
            Arrays.sort(word2Chars);
            result = Arrays.equals(word1Chars, word2Chars);
        }
        return result;
    }

    private static String normalize(String word) {
        String normalized = word
                .toLowerCase()
                .replace('ñ', '\001');

        normalized = Normalizer
                .normalize(normalized, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replace('\001', 'ñ');

        return normalized;
    }
}

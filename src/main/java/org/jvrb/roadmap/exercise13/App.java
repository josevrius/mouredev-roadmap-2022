package org.jvrb.roadmap.exercise13;

import java.text.Normalizer;
import java.util.Scanner;

public class App {

    private static final String HEADER = """
            
            COMPROBAR PALÍDROMO
            ===================
            Texto .....:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String text = enterText();
            System.out.println("Palíndromo : " + (isPalindrome(text) ? "SI" : "NO"));
        } catch (Exception e) {
            System.out.println("Error .....: " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = new Scanner(System.in).nextLine().strip();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Entrada nula");
        }
        return text;
    }

    private static String normalizeText(String text) {
        String normalized = text
                .toUpperCase()
                .replaceAll("[^A-ZÑÁÉÍÓÚÜ\\d]+", "")
                .replace('Ñ', '\001');

        normalized = Normalizer
                .normalize(normalized, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replace('\001', 'Ñ');

        return normalized;
    }

    private static boolean isPalindrome(String text) {
        String normalized = normalizeText(text);
        if (normalized.isEmpty()) {
            return false;
        }

        int i = 0;
        int j = normalized.length() - 1;
        while (i < j) {
            if (normalized.charAt(i) != normalized.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

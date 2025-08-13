package org.jvrb.roadmap.exercise13;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App13 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            COMPROBAR PALÍNDROMO
            ====================
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
        String text = SCN.nextLine().strip();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        return text;
    }

    private static String normalizeText(String text) {
        final Pattern DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        final Pattern NOT_ALLOWED_CHARS = Pattern.compile("[^A-ZÑ\\d]+");

        String normalized = text.toUpperCase().replace('Ñ', '\001');
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD);
        normalized = DIACRITICS.matcher(normalized).replaceAll("");
        normalized = NOT_ALLOWED_CHARS.matcher(normalized).replaceAll("");
        normalized = normalized.replace('\001', 'Ñ');

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

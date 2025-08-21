package roadmap.challenge48;

import java.text.Normalizer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public final class App {

    private static final String HEADER = """
            
            VOCAL MÁS COMÚN
            ===============""";

    public static void main(String[] args) {
        String text = "No ha mucho tiempo que vivía un hidalgo de los de lanza en astillero.";

        try {
            System.out.println(HEADER);
            String normalizedText = normalizeText(text);
            System.out.println("Texto : " + text);
            char vocal = getMostCommonVocal(normalizedText);
            System.out.println("Vocal : " + vocal);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static char getMostCommonVocal(String text) {
        HashMap<Character, Integer> counter = new HashMap<>();

        if (text.isEmpty()) {
            return ' ';
        }
        for (char vocal : text.toCharArray()) {
            counter.put(vocal, counter.getOrDefault(vocal, 0) + 1);
        }
        return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String normalizeText(String text) {
        Objects.requireNonNull(text, "El texto no puede ser nulo");

        final Pattern DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        final Pattern NOT_ALLOWED_CHARS = Pattern.compile("[^aeiou]+");

        String normalized = text.toLowerCase();
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD);
        normalized = DIACRITICS.matcher(normalized).replaceAll("");
        normalized = NOT_ALLOWED_CHARS.matcher(normalized).replaceAll("");

        return normalized;
    }
}

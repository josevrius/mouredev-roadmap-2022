package roadmap.challenge08;

import java.text.Normalizer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            PALABRAS REPETIDAS
            ==================
            Texto :\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String text = enterText();
            HashMap<String, Integer> counter = countRepeatedWords(text);
            printResult(counter);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = SCN.nextLine().strip();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        return text;
    }

    private static HashMap<String, Integer> countRepeatedWords(String text) {
        HashMap<String, Integer> counter = new HashMap<>();
        String[] words = text.toLowerCase().split("[^a-zñáéíóúü]+");
        normalizeWords(words);

        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        return counter;
    }

    private static void normalizeWords(String[] words) {
        final Pattern DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace('ñ', '\001');
            words[i] = Normalizer.normalize(words[i], Normalizer.Form.NFD);
            words[i] = DIACRITICS.matcher(words[i]).replaceAll("");
            words[i] = words[i].replace('\001', 'Ñ');
        }
    }

    private static void printResult(HashMap<String, Integer> counter) {
        System.out.println("------------------");
        counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                });
    }
}

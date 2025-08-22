package roadmap.challenge10;

import java.text.Normalizer;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final Map<Character, String> morseCode = Map.ofEntries(
            Map.entry('A', ".-"), Map.entry('B', "-..."), Map.entry('C', "-.-."),
            Map.entry('D', "-.."), Map.entry('E', "."), Map.entry('F', "..-."),
            Map.entry('G', "--."), Map.entry('H', "...."), Map.entry('I', ".."),
            Map.entry('J', ".---"), Map.entry('K', "-.-"), Map.entry('L', ".-.."),
            Map.entry('M', "--"), Map.entry('N', "-."), Map.entry('Ñ', "--.--"),
            Map.entry('O', "---"), Map.entry('P', ".--."), Map.entry('Q', "--.-"),
            Map.entry('R', ".-."), Map.entry('S', "..."), Map.entry('T', "-"),
            Map.entry('U', "..-"), Map.entry('V', "...-"), Map.entry('W', ".--"),
            Map.entry('X', "-..-"), Map.entry('Y', "-.--"), Map.entry('Z', "--.."),
            Map.entry('0', "-----"), Map.entry('1', ".----"), Map.entry('2', "..---"),
            Map.entry('3', "...--"), Map.entry('4', "....-"), Map.entry('5', "....."),
            Map.entry('6', "-...."), Map.entry('7', "--..."), Map.entry('8', "---.."),
            Map.entry('9', "----."), Map.entry('.', ".-.-.-"), Map.entry(',', "--..--"),
            Map.entry('?', "..--.."), Map.entry('"', ".-..-."), Map.entry('/', "-..-.")
    );

    private static final String HEADER = """
            
            CÓDIGO MORSE
            ============
            Entrada :\s""";

    public static void main(String[] args) {
        try {
            System.out.print(HEADER);
            String input = enterText();
            convert(convert(input));
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = SCN.nextLine().strip();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        return text;
    }

    private static String convert(String original) {
        String converted;

        if (original.startsWith("-") || original.startsWith(".")) {
            converted = decode(original);
            System.out.println("Texto ..: " + converted);
        } else {
            converted = encode(original);
            System.out.println("Morse ..: " + converted);
        }
        return converted;
    }

    private static String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        String normalizedText = normalizeText(text);

        for (char character : normalizedText.toCharArray()) {
            if (morseCode.containsKey(character)) {
                encodedText.append(morseCode.get(character)).append(' ');
            } else if (character == ' ') {
                encodedText.append(' ');
            } else if (character == '\n') {
                encodedText.deleteCharAt(encodedText.length() - 1);
                encodedText.append(System.lineSeparator());
            }
        }
        return encodedText.toString().strip();
    }

    private static String decode(String morse) {
        String normalizedMorse = normalizeMorse(morse);
        StringBuilder decodedMorse = new StringBuilder();

        for (String line : normalizedMorse.split("\n")) {
            for (String word : line.split(" {2,}")) {
                for (String character : word.split(" ")) {
                    morseCode.forEach((key, value) -> {
                        if (character.equals(value)) {
                            decodedMorse.append(key);
                        }
                    });
                }
                decodedMorse.append(' ');
            }
            decodedMorse.deleteCharAt(decodedMorse.length() - 1);
            decodedMorse.append(System.lineSeparator());
        }
        return decodedMorse.toString().strip();
    }

    private static String normalizeText(String text) {
        final Pattern DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        final Pattern NOT_ALLOWED_CHARS = Pattern.compile("\\s{2,}");

        String normalized = text.toUpperCase().replace('Ñ', '\001');
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD);
        normalized = DIACRITICS.matcher(normalized).replaceAll("");
        normalized = NOT_ALLOWED_CHARS.matcher(normalized).replaceAll("");
        normalized = normalized.replace('\001', 'Ñ');

        return normalized;
    }

    private static String normalizeMorse(String morse) {
        return morse.replaceAll("[^.\\-\\s]+", "");
    }
}

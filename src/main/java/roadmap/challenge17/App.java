package roadmap.challenge17;

import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            EN MAYÚSCULA
            ============
            Texto .......:\s""";

    public static void main(String[] args) {
        try {
            System.out.print(HEADER);
            String text = enterText();
            System.out.println("Capitalizado : " + capitalize(text));
        } catch (Exception e) {
            System.out.println("Error .......: " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = SCN.nextLine().strip();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        return text;
    }

    private static String capitalize(String text) {
        StringBuilder capitalizedText = new StringBuilder();

        if (text != null && !text.isEmpty()) {
            for (String word : text.split("\\s+")) {
                capitalizedText
                        .append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return capitalizedText.toString().strip();
    }
}

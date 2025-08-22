package roadmap.challenge07;

import java.util.Scanner;

public final class App {

    private static final String HEADER = """
            
            CADENAS INVERTIDAS
            ==================
            Texto ....:\s""";

    public static void main(String[] args) {
        try {
            System.out.print(HEADER);
            String text = enterText();
            String reversedText = reverseOrder(text);
            System.out.println("Invertido : " + reversedText);
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    private static String enterText() {
        String text = new Scanner(System.in).nextLine();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        return text;
    }

    private static String reverseOrder(String text) {
        StringBuilder reversed = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            reversed.append(c);
        }
        return reversed.toString();
    }
}

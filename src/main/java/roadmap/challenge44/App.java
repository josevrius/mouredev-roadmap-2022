package roadmap.challenge44;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);
    private static final Random RND = new Random();

    private enum Halloween {
        TRICK, TREAT
    }

    private record Kid(String name, int age, int height) {
    }

    private static final String[] scariesCollection = {"🎃", "👻", "💀", "🕷", "🕸", "🦇"};
    private static final String[] candiesCollection = {"🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"};

    private static final String HEADER = """
            
            HALLOWEEN
            =========
            [1] Truco
            [2] Trato
            
            Opción :\s""";

    public static void main(String[] args) {
        Kid[] kids = {
                new Kid("Jose", 45, 167),
                new Kid("Sara", 9, 122),
                new Kid("Pedro", 5, 80),
                new Kid("Marta", 12, 143)
        };

        try {
            System.out.print(HEADER);
            Halloween trickOrTread = enterOption();
            goTrickOrTreat(trickOrTread, kids);
        } catch (Exception e) {
            System.out.println("Error .: " + e.getMessage());
        }
    }

    private static Halloween enterOption() {
        Pattern validInput = Pattern.compile("[1-2]");
        String input = SCN.nextLine();

        if (!validInput.matcher(input).matches()) {
            throw new IllegalArgumentException("Opción incorrecta");
        }
        return input.equals("1") ? Halloween.TRICK : Halloween.TREAT;
    }

    private static void goTrickOrTreat(Halloween halloween, Kid[] kids) {
        if (kids == null || kids.length == 0) {
            throw new IllegalArgumentException("No hay niños en la puerta");
        }

        switch (halloween) {
            case TRICK -> {
                int scariesCount = 0;
                int totalHeight = 0;

                for (Kid kid : kids) {
                    scariesCount += kid.name.length() / 2;
                    if (kid.age % 2 == 0) scariesCount += 2;
                    totalHeight += kid.height;
                }
                scariesCount += totalHeight / 100 * 3;

                String scariesChain = buildEmojisChain(scariesCount, scariesCollection);
                System.out.println("Truco .: " + scariesChain);
            }
            case TREAT -> {
                int candiesCount = 0;

                for (Kid kid : kids) {
                    candiesCount += kid.name.length();
                    candiesCount += kid.age > 10 ? 10 / 3 : kid.age / 3;
                    candiesCount += kid.height > 150 ? 150 / 50 * 2 : kid.height / 50 * 2;
                }
                String candiesChain = buildEmojisChain(candiesCount, candiesCollection);
                System.out.println("Trato .: " + candiesChain);
            }
            default -> throw new IllegalArgumentException("Te has equivocado de festividad");
        }
    }

    private static String buildEmojisChain(int counter, String[] source) {
        StringBuilder emojis = new StringBuilder();

        for (int i = 1; i <= counter; i++) {
            emojis.append(source[RND.nextInt(source.length)]);
        }
        return emojis.toString();
    }
}

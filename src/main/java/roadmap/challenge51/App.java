package roadmap.challenge51;

public final class App {

    private enum Karaka {
        ENCODE, DECODE
    }

    private static final String HEADER = """
            
            CóDIGO KARAKA
            =============""";

    public static void main(String[] args) {
        String text = "Este es el penúltimo reto de programación del año";

        System.out.println(HEADER);
        System.out.println("Entrada : " + text);
        String processed = processText(text, Karaka.ENCODE);
        System.out.println("Salida .: " + processed);
    }

    private static String processText(String text, Karaka karaka) {
        StringBuilder result = new StringBuilder();

        for (String word : text.strip().toLowerCase().split("\\s+")) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            switch (karaka) {
                case ENCODE -> {
                    result.append(reversedWord
                            .replace("a", "0")
                            .replace("e", "1")
                            .replace("i", "2")
                            .replace("o", "3")
                            .replace("u", "4")
                    );
                    result.append("aca").append(" ");
                }
                case DECODE -> {
                    if (reversedWord.startsWith("aca")) reversedWord = reversedWord.substring(3);
                    result.append(reversedWord
                            .replace("0", "a")
                            .replace("1", "e")
                            .replace("2", "i")
                            .replace("3", "o")
                            .replace("4", "u")
                    );
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }
}

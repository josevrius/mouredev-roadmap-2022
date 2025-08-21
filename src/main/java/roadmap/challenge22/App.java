package roadmap.challenge22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;

public final class App {

    private static final String HEADER = """
            
            CALCULADORA TXT
            ===============""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            String operations = loadFile();
            double result = calculate(operations);
            System.out.println(operations.replace("\n", "") + " = " + NumberFormat.getNumberInstance().format(result));
        } catch (Exception e) {
            System.out.println("Error : " + (e instanceof IOException ? "Fichero no encontrado" : e.getMessage()));
        }
    }

    private static String loadFile() throws IOException {
        return Files.readString(Path.of("./src/main/resources/challenge22.txt"));
    }

    private static double calculate(String operations) {
        if (!operations.replace("\n", "").matches("(\\d+\\.?\\d*[+\\-*/])+\\d+\\.?\\d*")) {
            throw new IllegalArgumentException("Fichero de operaciones no válido");
        }

        String[] entries = operations.split("\n");
        double result = Double.parseDouble(entries[0]);

        for (int i = 1; i < entries.length - 1; i += 2) {
            switch (entries[i]) {
                case "+" -> result += Double.parseDouble(entries[i + 1]);
                case "-" -> result -= Double.parseDouble(entries[i + 1]);
                case "*" -> result *= Double.parseDouble(entries[i + 1]);
                case "/" -> result /= Double.parseDouble(entries[i + 1]);
            }
        }
        return result;
    }
}

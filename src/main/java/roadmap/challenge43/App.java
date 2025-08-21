package roadmap.challenge43;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CONVERSOR DE TEMPERATURA
            ========================""";

    public static void main(String[] args) {
        try {
            System.out.println(HEADER);
            String temp = enterTemp();
            convertTemp(temp);
        } catch (Exception e) {
            System.out.println("Error ......: " + e.getMessage());
        }
    }

    private static String enterTemp() {
        Pattern validInput = Pattern.compile("-?\\d+(,?\\d+)?º[CF]");

        System.out.print("Temperatura : ");
        String temp = SCN.nextLine().strip().toUpperCase();

        if (!validInput.matcher(temp).matches()) {
            throw new IllegalArgumentException("Temperatura no válida");
        }
        return temp;
    }

    private static void convertTemp(String input) {
        double temp = Double.parseDouble(input.split("º")[0].replace(',', '.'));
        NumberFormat numeric = NumberFormat.getNumberInstance();
        numeric.setMaximumFractionDigits(2);

        if (input.contains("C")) {
            double fahrenheit = ((temp * 9 / 5) + 32);
            System.out.println("Fahrenheit .: " + (numeric.format(fahrenheit)) + "ºF");
        } else {
            double celsius = ((temp - 32) * 5 / 9);
            System.out.println("Celsius ....: " + numeric.format(celsius) + "ºC");
        }
    }
}

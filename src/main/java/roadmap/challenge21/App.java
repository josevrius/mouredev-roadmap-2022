package roadmap.challenge21;

import java.text.NumberFormat;
import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            PARANDO EL TIEMPO
            =================""";

    public static void main(String[] args) {
        try {
            System.out.println(HEADER);
            double n1 = enterNumber("Número 1 .: ");
            double n2 = enterNumber("Número 2 .: ");
            int delay = enterDelay();
            double sum = sumAfterDelay(n1, n2, delay);
            System.out.println("Suma .....: " + NumberFormat.getNumberInstance().format(sum));
        } catch (Exception e) {
            System.out.println("Error ....: " + e.getMessage());
        }
    }

    private static double enterNumber(String msg) {
        System.out.print(msg);
        String input = SCN.nextLine().strip().replace(',', '.');
        validateNumber(input, msg);

        return Double.parseDouble(input);
    }

    private static int enterDelay() {
        System.out.print("Retardo ..: ");
        String input = SCN.nextLine().strip();
        validateDelay(input);

        return Integer.parseInt(input);
    }

    private static double sumAfterDelay(double n1, double n2, int delaySeconds) {
        if (delaySeconds > 0) {
            System.out.print("Esperando : ");

            for (int i = 1; i <= delaySeconds; i++) {
                System.out.print(i > 1 ? ", " + i : i);
                if (i == delaySeconds) System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return n1 + n2;
    }

    private static void validateNumber(String input, String msg) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        if (!input.matches("[+-]?([.,]\\d+|\\d+[.,]?\\d*)")) {
            throw new IllegalArgumentException("No es un número");
        }
    }

    private static void validateDelay(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("No es un número entero positivo");
        }
        if (Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException("Superior al límite (20)");
        }
    }
}

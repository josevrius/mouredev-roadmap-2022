package roadmap.challenge20;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CONVERSOR MILISEGUNDOS
            ======================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            int d = enterValue("Días ........: ");
            int h = enterValue("Horas .......: ");
            int m = enterValue("Minutos .....: ");
            int s = enterValue("Segundos ....: ");
            System.out.println("Milisegundos : " + convertToMillis(d, h, m, s));
        } catch (Exception e) {
            System.out.println("Error .......: " + e.getMessage());
        }
    }

    private static int enterValue(String msg) {
        System.out.print(msg);

        if (!SCN.hasNextInt()) {
            throw new InputMismatchException("No es un número entero");
        }
        int value = SCN.nextInt();

        if (value < 0) {
            throw new IllegalArgumentException("No se permiten números negativos");
        }
        return value;
    }

    private static long convertToMillis(int days, int hours, int minutes, int seconds) {
        return Duration
                .ofDays(days)
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds)
                .toMillis();
    }
}

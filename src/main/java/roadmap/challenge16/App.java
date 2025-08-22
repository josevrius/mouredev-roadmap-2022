package roadmap.challenge16;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            CONTADOR DE DÍAS
            ================""";

    public static void main(String[] args) {
        try {
            System.out.println(HEADER);
            String date = enterDate(1);
            String anotherDate = enterDate(2);
            int days = getDaysBetween(date, anotherDate);
            System.out.println("Días ...: " + NumberFormat.getInstance().format(days));
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static String enterDate(int i) {
        System.out.printf("Fecha %d : ", i);
        String date = SCN.nextLine().strip();

        if (date.isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }
        String datePattern = "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}";
        if (!date.matches(datePattern)) {
            throw new IllegalArgumentException("Formato de fecha no válido");
        }
        return date;
    }

    private static int getDaysBetween(String date, String anotherDate) {
        int[] rd1 = restructure(date);
        LocalDate ld1 = LocalDate.of(rd1[0], rd1[1], rd1[2]);

        int[] rd2 = restructure(anotherDate);
        LocalDate ld2 = LocalDate.of(rd2[0], rd2[1], rd2[2]);

        return Math.toIntExact(Math.abs(ChronoUnit.DAYS.between(ld1, ld2)));
    }

    private static int[] restructure(String date) {
        int d = Integer.parseInt(date.substring(0, 2));
        int m = Integer.parseInt(date.substring(3, 5));
        int y = Integer.parseInt(date.substring(6, 10));

        return new int[]{y, m, d};
    }
}

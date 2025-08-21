package roadmap.challenge49;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public final class App {

    private static final LocalDateTime FIRST_DAY = LocalDateTime.of(2022, 12, 1, 0, 0, 0);
    private static final LocalDateTime LAST_DAY = LocalDateTime.of(2022, 12, 24, 23, 59, 59);

    private static final Map<Integer, String> GIFTS = Map.ofEntries(
            Map.entry(1, "💄"), Map.entry(2, "🏈"), Map.entry(3, "🎎"),
            Map.entry(4, "🎏"), Map.entry(5, "🎑"), Map.entry(6, "🎠"),
            Map.entry(7, "🧵"), Map.entry(8, "🎨"), Map.entry(9, "🪡"),
            Map.entry(10, "🧦"), Map.entry(11, "🩲"), Map.entry(12, "⛑️"),
            Map.entry(13, "🥎"), Map.entry(14, "👓"), Map.entry(15, "👔"),
            Map.entry(16, "🎀"), Map.entry(17, "👟"), Map.entry(18, "🧤"),
            Map.entry(19, "👙"), Map.entry(20, "🪮"), Map.entry(21, "👜"),
            Map.entry(22, "🎋"), Map.entry(23, "🧶"), Map.entry(24, "🪭")
    );

    private static final String HEADER = """
            
            CALENDARIO DE ADEVIENTO 2022
            ============================""";

    public static void main(String[] args) {
        try {
            LocalDateTime date = LocalDateTime.of(2022, 12, 11, 23, 32, 30);

            System.out.println(HEADER);
            System.out.println("Fecha .: " + DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy").format(date));
            System.out.println("Hora ..: " + DateTimeFormatter.ofPattern("HH:mm:ss").format(date));
            System.out.println("Regalo : " + getGift(date));
        } catch (Exception e) {
            System.out.println("Error .: " + e.getMessage());
        }
    }

    private static String getGift(LocalDateTime date) {
        if (date.isBefore(FIRST_DAY)) {
            long[] remainingTime = getTimeBetween(date, FIRST_DAY);
            String msg = formatMessage(remainingTime);
            return "El calendario de aDEViento 2022 comenzará en " + msg;
        } else if (date.isAfter(LAST_DAY)) {
            long[] elapsedTime = getTimeBetween(LAST_DAY, date);
            String msg = formatMessage(elapsedTime);
            return "El calendario de aDEViento 2022 finalizó hace " + msg;
        } else {
            return GIFTS.get(date.getDayOfMonth());
        }
    }

    private static long[] getTimeBetween(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);

        long d = duration.toDays();
        long h = duration.minusDays(d).toHours();
        long m = duration.minusDays(d).minusHours(h).toMinutes();
        long s = duration.minusDays(d).minusHours(h).minusMinutes(m).toSeconds();

        return new long[]{d, h, m, s};
    }

    private static String formatMessage(long[] time) {
        String d = time[0] == 0 ? "" : time[0] == 1 ? time[0] + " día " : time[0] + " días ";
        String h = time[1] == 0 ? "" : time[1] == 1 ? time[1] + " hora " : time[1] + " horas ";
        String m = time[2] == 0 ? "" : time[2] == 1 ? time[2] + " minuto " : time[2] + " minutos ";
        String s = time[3] == 0 ? "" : time[3] == 1 ? time[3] + " segundo " : time[3] + " segundos ";

        return d + h + m + s;
    }
}

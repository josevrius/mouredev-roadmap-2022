package roadmap.challenge38;

import java.time.LocalDate;
import java.time.Period;

public final class App {

    private enum Game {
        THE_LEGEND_OF_ZELDA("1986-02-21"),
        THE_ADVENTURE_OF_LINK("1987-01-14"),
        A_LINK_TO_THE_PAST("1991-11-21"),
        LINKS_AWAKENING("1993-06-06"),
        OCARINA_OF_TIME("1998-11-21"),
        MAJORAS_MASK("2000-04-27"),
        ORACLE_OF_SEASONS("2001-02-27"),
        ORACLE_OF_AGES("2001-02-27"),
        FOUR_SWORDS("2002-12-02"),
        THE_WIND_WAKER("2002-11-13"),
        FOUR_SWORDS_ADVENTURES("2004-03-18"),
        THE_MINISH_CAP("2004-11-04"),
        TWILIGHT_PRINCESS("2006-12-02"),
        PHANTOM_HOURGLASS("2007-06-23"),
        SPIRIT_TRACKS("2009-12-07"),
        SKYWARD_SWORD("2011-11-18"),
        A_LINK_BETWEEN_WORLDS("2013-11-22"),
        TRI_FORCE_HEROES("2015-09-22"),
        BREATH_OF_THE_WILD("2017-03-03"),
        TEARS_OF_THE_KINGDOM("2023-05-12");

        private final String date;

        Game(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }
    }

    private static final String HEADER = """
            
            THE LEGEND OF ZELDA
            ===================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        Game game1 = Game.OCARINA_OF_TIME;
        Game game2 = Game.BREATH_OF_THE_WILD;
        long[] elapsedTime = getTimeBetween(game1, game2);
        showElapsedTime(game1, game2, elapsedTime);
    }

    private static long[] getTimeBetween(Game game1, Game game2) {
        LocalDate date1 = LocalDate.parse(game1.getDate());
        LocalDate date2 = LocalDate.parse(game2.getDate());

        if (date1.isAfter(date2)) {
            LocalDate aux = date1;
            date1 = date2;
            date2 = aux;
        }

        Period period = Period.between(date1, date2);
        long y = period.getYears();
        long m = period.minusYears(y).getMonths();
        long d = period.minusYears(y).minusMonths(m).getDays();

        return new long[]{y, m, d};
    }

    private static void showElapsedTime(Game game1, Game game2, long[] time) {
        long y = time[0];
        long m = time[1];
        long d = time[2];

        String yearsText = y == 0 ? "" : y == 1 ? y + " año" : y + " años";
        String monthsText = m == 0 ? "" : m == 1 ? m + " mes" : m + " meses";
        String daysText = d == 0 ? "" : d == 1 ? d + " día" : d + " días";

        if (y != 0 && m != 0 && d != 0) {
            monthsText = ", " + monthsText;
        } else if (y != 0 && d == 0) {
            monthsText = " y " + monthsText;
        }
        if (y != 0 && d != 0 || m != 0 && d != 0) {
            daysText = " y " + daysText;
        }
        System.out.printf("Entre los lanzamientos de %s y %s\nhan transcurrido %s%s%s%n", game1, game2, yearsText, monthsText, daysText);
    }
}

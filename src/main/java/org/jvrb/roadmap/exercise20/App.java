package org.jvrb.roadmap.exercise20;

import java.time.Duration;

public class App {

    private static final String HEADER = """
            
            CONVERSOR MILISEGUNDOS
            ======================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            System.out.println("Milisegundos : " + getMilliseconds(5, 3, 20, 10));
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static long getMilliseconds(int days, int hours, int minutes, int seconds) {
        if (days < 0 || hours < 0 || minutes < 0 || seconds < 0) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }

        return Duration
                .ofDays(days)
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds)
                .toMillis();
    }
}

package org.jvrb.roadmap.exercise18;

import java.util.Random;

public class App {

    private static final Random RND = new Random();

    private static final String HEADER = """
            
            CARRERA DE OBSTÁCULOS
            =====================""";

    public static void main(String[] args) {
        String[] actions = {"jump", "run"};
        String track = "_|__|_";

        System.out.println(HEADER);
        try {
            System.out.println("Superada : " + (isRaceCompleted(actions, track) ? "SI" : "NO"));
        } catch (Exception e) {
            System.out.println("Error ...: " + e.getMessage());
        }
    }

    private static boolean isRaceCompleted(String[] actions, String track) {
        if (!track.matches("[_|]*")) {
            throw new IllegalArgumentException("Invalid track");
        }
        StringBuilder race = new StringBuilder();

        for (int i = 0; i < track.length(); i++) {
            char obstacle = track.charAt(i);
            String action = actions[RND.nextInt(actions.length)];

            switch (obstacle) {
                case '_' -> race.append(action.equals("run") ? obstacle : "x");
                case '|' -> race.append(action.equals("jump") ? obstacle : "/");
                default -> throw new IllegalArgumentException("Invalid obstacle");
            }
        }
        System.out.println("Pista ...: " + track);
        System.out.println("Carrera .: " + race);
        return track.contentEquals(race);
    }
}

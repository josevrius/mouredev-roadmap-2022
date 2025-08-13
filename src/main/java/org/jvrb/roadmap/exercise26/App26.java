package org.jvrb.roadmap.exercise26;

import java.util.List;

public final class App26 {

    private enum Play {
        PIEDRA, PAPEL, TIJERA;

        private boolean winsTo(Play play) {
            return (this == PIEDRA && play == TIJERA)
                    || (this == PAPEL && play == PIEDRA)
                    || (this == TIJERA && play == PAPEL);
        }
    }

    private static final String HEADER = """
            
            PIEDRA, PAPEL, TIJERA
            =====================""";

    public static void main(String[] args) {
        List<Play[]> plays = List.of(
                new Play[]{Play.PIEDRA, Play.TIJERA},
                new Play[]{Play.TIJERA, Play.PIEDRA},
                new Play[]{Play.PAPEL, Play.TIJERA},
                new Play[]{Play.PAPEL, Play.PAPEL},
                new Play[]{Play.PAPEL, Play.PIEDRA},
                new Play[]{Play.TIJERA, Play.PAPEL},
                new Play[]{Play.PIEDRA, Play.PAPEL},
                new Play[]{Play.TIJERA, Play.PIEDRA}
        );
        System.out.println(HEADER);
        print(plays);
        System.out.println("Ganador ..: " + checkWinner(plays));
    }

    private static void print(List<Play[]> plays) {
        for (Play[] play : plays) {
            System.out.println("Jugador 1 : " +  play[0]);
            System.out.println("Jugador 2 : " +  play[1]);
            System.out.println("-----------");
        }
    }

    private static String checkWinner(List<Play[]> plays) {
        int p1Counter = 0;
        int p2Counter = 0;

        for (Play[] player : plays) {
            if (!player[0].equals(player[1])) {
                if (player[0].winsTo(player[1])) {
                    p1Counter++;
                } else {
                    p2Counter++;
                }
            }
        }
        return p1Counter > p2Counter ? "JUGADOR 1" : p1Counter < p2Counter ? "JUGADOR 2" : "EMPATE";
    }
}

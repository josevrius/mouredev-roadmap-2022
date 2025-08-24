package roadmap.challenge26;

import java.util.ArrayList;
import java.util.List;

public final class App {

    private enum Sign {
        PIEDRA, PAPEL, TIJERA;

        private boolean winsTo(Sign sign) {
            return this == PIEDRA && sign == TIJERA
                    || this == PAPEL && sign == PIEDRA
                    || this == TIJERA && sign == PAPEL;
        }
    }

    private record Round(Sign player1, Sign player2) {
    }

    private record Scores(int player1, int player2) {
    }

    private static final String HEADER = """
            
            PIEDRA, PAPEL, TIJERA
            =====================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        List<Round> rounds = setRounds();
        Scores game = playGame(rounds);
        showResult(game);
    }

    private static List<Round> setRounds() {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(Sign.PIEDRA, Sign.PIEDRA));
        rounds.add(new Round(Sign.TIJERA, Sign.PAPEL));
        rounds.add(new Round(Sign.PAPEL, Sign.PIEDRA));
        rounds.add(new Round(Sign.TIJERA, Sign.PIEDRA));

        return rounds;
    }

    private static Scores playGame(List<Round> rounds) {
        int p1Score = 0;
        int p2Score = 0;

        for (int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            System.out.printf("Ronda %d : %s vs %s%n", i + 1, round.player1, round.player2);
            if (round.player1 != round.player2) {
                if (round.player1.winsTo(round.player2)) {
                    p1Score++;
                } else {
                    p2Score++;
                }
            }
        }
        return new Scores(p1Score, p2Score);
    }

    private static void showResult(Scores score) {
        String result;

        if (score.player1 > score.player2) {
            result = "Jugador 1";
        } else if (score.player1 < score.player2) {
            result = "Jugador 2";
        } else {
            result = "Empate";
        }
        System.out.println("Ganador : " + result);
    }
}

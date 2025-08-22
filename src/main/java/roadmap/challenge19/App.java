package roadmap.challenge19;

public final class App {

    private static final String HEADER = """
            
            TRES EN RAYA
            ============""";

    public static void main(String[] args) {
        Character[][] board = new Character[][]{
                {'O', null, 'P'},
                {'o', 'X', 'X'},
                {'O', 'x', 'O'},
        };

        try {
            System.out.println(HEADER);
            normalize(board);
            print(board);
            System.out.println("Ganador : " + checkWinner(board));
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void normalize(Character[][] board) {
        if (board == null) {
            throw new NullPointerException("Tablero no encontrado");
        }
        if (board.length != 3) {
            throw new IllegalArgumentException("Formato del tablero no válido");
        }
        for (Character[] file : board) {
            if (file.length != 3) {
                throw new IllegalArgumentException("Formato del tablero no válido");
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cell = board[row][col] == null ? ' ' : Character.toUpperCase(board[row][col]);
                board[row][col] = (cell == 'X' || cell == 'O') ? cell : ' ';
            }
        }
    }

    private static void print(Character[][] board) {
        for (int row = 0; row < 3; row++) {
            System.out.printf(" %c | %c | %c %n", board[row][0], board[row][1], board[row][2]);
            if (row < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    private static String checkWinner(Character[][] board) {
        final Character[][] WINNING_COMBS = new Character[][]{
                {board[0][0], board[0][1], board[0][2]},
                {board[1][0], board[1][1], board[1][2]},
                {board[2][0], board[2][1], board[2][2]},
                {board[0][0], board[1][0], board[2][0]},
                {board[0][1], board[1][1], board[2][1]},
                {board[0][2], board[1][2], board[2][2]},
                {board[0][0], board[1][1], board[2][2]},
                {board[0][2], board[1][1], board[2][0]}
        };

        for (Character[] row : WINNING_COMBS) {
            if (row[0] == 'X' && row[1] == 'X' && row[2] == 'X') {
                return "X";
            }
            if (row[0] == 'O' && row[1] == 'O' && row[2] == 'O') {
                return "O";
            }
        }
        return "Empate";
    }
}

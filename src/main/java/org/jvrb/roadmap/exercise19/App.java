package org.jvrb.roadmap.exercise19;

public class App {

    private static final String HEADER = """
            
            TRES EN RAYA
            ============""";

    public static void main(String[] args) {
        Character[][] board = new Character[][]{
                {'O', null, 'P'},
                {'o', 'X', 'X'},
                {'O', 'x', 'O'},
        };

        System.out.println(HEADER);
        try {
            validate(board);
            normalize(board);
            print(board);
            System.out.println("Ganador : " + checkWinner(board));
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void validate(Character[][] board) {
        if (board == null) {
            throw new NullPointerException("Cannot load the board");
        }
        if (board.length != 3) {
            throw new IllegalArgumentException("Invalid format board");
        }
        for (Character[] file : board) {
            if (file.length != 3) {
                throw new IllegalArgumentException("Invalid format board");
            }
        }
    }

    private static void normalize(Character[][] board) {
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
        Character[][] winnerCombinations = getWinnerCombinations(board);

        for (Character[] combination : winnerCombinations) {
            if (combination[0] == 'X' && combination[1] == 'X' && combination[2] == 'X') {
                return "X";
            }
            if (combination[0] == 'O' && combination[1] == 'O' && combination[2] == 'O') {
                return "O";
            }
        }
        return "Empate";
    }

    private static Character[][] getWinnerCombinations(Character[][] board) {
        Character[] c1 = {board[0][0], board[0][1], board[0][2]};
        Character[] c2 = {board[1][0], board[1][1], board[1][2]};
        Character[] c3 = {board[2][0], board[2][1], board[2][2]};

        Character[] c4 = {board[0][0], board[1][0], board[2][0]};
        Character[] c5 = {board[0][1], board[1][1], board[2][1]};
        Character[] c6 = {board[0][2], board[1][2], board[2][2]};

        Character[] c7 = {board[0][0], board[1][1], board[2][2]};
        Character[] c8 = {board[0][2], board[1][1], board[2][0]};

        return new Character[][]{c1, c2, c3, c4, c5, c6, c7, c8};
    }
}

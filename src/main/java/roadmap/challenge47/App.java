package roadmap.challenge47;

import java.util.Arrays;

public final class App {

    private enum Direction {
        NORTH, SOUTH, EAST, WEST;

        public final Direction turn() {
            Direction direction = this;

            switch (this) {
                case NORTH -> direction = WEST;
                case SOUTH -> direction = EAST;
                case EAST -> direction = NORTH;
                case WEST -> direction = SOUTH;
            }
            return direction;
        }
    }

    private static final String HEADER = """
            
            ¿DÓNDE ESTÁ EL ROBOT? 🤖
            ========================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        int[] initial = {0, 0};
        int[] steps = {10, 5, -2};
        int[] position = calculateCoordinates(initial, steps);
        System.out.println("Posición inicial : " + Arrays.toString(initial));
        System.out.println("Pasos ...........: " + Arrays.toString(steps));
        System.out.println("Posición final ..: " + Arrays.toString(position));
    }

    private static int[] calculateCoordinates(int[] initial, int[] steps) {
        int x = initial[0];
        int y = initial[1];
        Direction direction = Direction.NORTH;

        for (int step : steps) {
            switch (direction) {
                case NORTH -> y += step;
                case SOUTH -> y -= step;
                case EAST -> x += step;
                case WEST -> x -= step;
            }
            direction = direction.turn();
        }
        return new int[]{x, y};
    }
}

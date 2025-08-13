package org.jvrb.roadmap.exercise30;

import java.util.Arrays;
import java.util.Random;

public final class App30 {

    private static final Random RND = new Random();

    private enum Direction {
        ASC, DESC;
    }

    private static final String HEADER = """
            
            ORDENA LA LISTA
            ===============""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        int[] numbers = createArray();
        System.out.println("Lista original ...: " + Arrays.toString(numbers));
        int[] numbersAscending = orderArray(numbers, Direction.ASC);
        System.out.println("Lista ascendente .: " + Arrays.toString(numbersAscending));
        int[] numbersDescending = orderArray(numbers, Direction.DESC);
        System.out.println("Lista descendente : " + Arrays.toString(numbersDescending));
    }

    private static int[] createArray() {
        int[] array = new int[9];

        for (int i = 0; i < array.length; i++) {
            array[i] = RND.nextInt(100);
        }
        return array;
    }

    private static int[] orderArray(int[] array, Direction direction) {
        int[] ordered = array.clone();

        if (ordered.length > 1) {
            for (int i = 0; i < ordered.length - 1; i++) {
                for (int j = i + 1; j < ordered.length; j++) {
                    boolean checkDirection = direction == Direction.ASC ? ordered[i] > ordered[j] : ordered[i] < ordered[j];
                    if (checkDirection) {
                        int aux = ordered[i];
                        ordered[i] = ordered[j];
                        ordered[j] = aux;
                    }
                }
            }
        }
        return ordered;
    }
}

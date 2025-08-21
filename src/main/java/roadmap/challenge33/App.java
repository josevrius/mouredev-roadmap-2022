package roadmap.challenge33;

import java.util.*;

public final class App {

    private static final Random RND = new Random();

    private static final String HEADER = """
            
            EL SEGUNDO
            ==========""";

    public static void main(String[] args) {
        int[] numbers = createRandomList();

        System.out.println(HEADER);
        try {
            printList(numbers);
            System.out.println("Segundo : " + getSecondMax(numbers));
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static int[] createRandomList() {
        int[] numbers = new int[9];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = RND.nextInt(10) + 1;
        }
        return numbers;
    }

    private static void printList(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("La lista está vacía");
        }
        System.out.print("Lista ..: ");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i < numbers.length - 1 ? " " : System.lineSeparator()));
        }
    }

    private static int getSecondMax(int[] numbers) {
        if (numbers.length == 1) {
            throw new IllegalArgumentException("La lista sólo contiene un número");
        }
        if (areTheSame(numbers)) {
            throw new IllegalArgumentException("Todos los números son iguales");
        }

        int max = 0;
        int secondMax = 0;

        for (int i : numbers) {
            if (i > max) {
                secondMax = max;
                max = i;
            } else if (i > secondMax && i < max) {
                secondMax = i;
            }
        }
        return secondMax;
    }

    private static boolean areTheSame(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[0] != numbers[i]) {
                return false;
            }
        }
        return true;
    }
}

package roadmap.challenge35;

import java.util.*;
import java.util.stream.IntStream;

public final class App {

    private static final Random RND = new Random();

    private static final String HEADER = """
            
            LOS NÚMEROS PERDIDOS
            ====================""";

    public static void main(String[] args) {
        try {
            System.out.println(HEADER);
            TreeSet<Integer> numbers = createRandomSet(5);
            System.out.println("Listado .: " + numbers);
            System.out.println("Perdidos : " + getLost(numbers));
        } catch (Exception e) {
            System.out.println("Error ...: " + e.getMessage());
        }
    }

    private static TreeSet<Integer> createRandomSet(int length) {
        if (length < 2 || length > 9) {
            throw new IllegalArgumentException("El listado debe tener entre 2 y 9 números");
        }
        TreeSet<Integer> randomSet = new TreeSet<>();
        List<Integer> availableNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 9).forEach(availableNumbers::add);

        for (int i = 0; i < length; i++) {
            int index = RND.nextInt(availableNumbers.size());
            randomSet.add(availableNumbers.remove(index));
        }
        return randomSet;
    }

    private static List<Integer> getLost(TreeSet<Integer> numbers) {
        List<Integer> lostNumbers = new ArrayList<>();
        int firstNumber = numbers.first();
        int lastNumber = numbers.last();
        List<Integer> completeSequence = new ArrayList<>();
        IntStream.rangeClosed(firstNumber, lastNumber).forEach(completeSequence::add);

        completeSequence.forEach(number -> {
            if (!numbers.contains(number)) lostNumbers.add(number);
        });
        return lostNumbers;
    }
}

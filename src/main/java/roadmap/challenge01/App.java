package roadmap.challenge01;

public final class App {

    private static final String HEADER = """
            
            FIZZ BUZZ
            =========""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        printFizzBuzz();
    }

    private static void printFizzBuzz() {
        for (int number = 1; number <= 100; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (number % 3 == 0) {
                System.out.println("fizz");
            } else if (number % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(number);
            }
            if (number < 100) System.out.println();
        }
    }
}

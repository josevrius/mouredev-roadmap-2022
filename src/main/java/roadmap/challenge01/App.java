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
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
            if (i < 100) {
                System.out.println();
            }
        }
    }
}

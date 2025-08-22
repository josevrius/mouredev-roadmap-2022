package roadmap.challenge04;

public final class App {

    private static final String HEADER = """
            
            NÚMEROS PRIMOS
            ==============""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

package roadmap.challenge32;

public final class App {

    private static final String HEADER = """
            
            AÑOS BISIESTOS
            ==============""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        printLeapYearsSince(2025, 5);
    }

    private static void printLeapYearsSince(int year, int count) {
        while (count > 0) {
            year++;
            if (isLeap(year)) {
                count--;
                System.out.println(year);
            }
        }
    }

    private static boolean isLeap(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}

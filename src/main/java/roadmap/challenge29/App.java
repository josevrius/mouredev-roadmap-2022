package roadmap.challenge29;

import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String MAIN_MENU = """
            
            MÁQUINA EXPENDEDORA (Crédito: %s)
            =======================
            [1] AGUA .......: %s
            [2] REFRESCO ...: %s
            [3] CERVEZA ....: %s
            [4] CHOCOLATINA : %s
            [5] PIPAS ......: %s
            [6] SANDWICH ...: %s
            
            [I] Insertar monedas
            [D] Devolver crédito
            
            Opción :\s""";

    private static final String INSERT_COIN_MENU = """
            
            INSERTAR MONEDAS (Crédito: %s)
            ======================
            [1] 0.01€    [2] 0.02€
            [3] 0.05€    [4] 0.10€
            [5] 0.20€    [6] 0.50€
            [7] 1.00€    [8] 2.00€
            
            [0] Volver
            
            Opción :\s""";

    private static final Map<String, Double> prices = Map.ofEntries(
            Map.entry("1", 0.6),
            Map.entry("2", 1.1),
            Map.entry("3", 1.4),
            Map.entry("4", 0.8),
            Map.entry("5", 0.65),
            Map.entry("6", 2.15)
    );

    private static double credit = 0;

    public static void main(String[] args) {
        boolean exit = false;

        do {
            try {
                System.out.printf(MAIN_MENU, formatCurrency(credit),
                        formatCurrency(prices.get("1")), formatCurrency(prices.get("2")),
                        formatCurrency(prices.get("3")), formatCurrency(prices.get("4")),
                        formatCurrency(prices.get("5")), formatCurrency(prices.get("6"))
                );
                String option = enterOption("[1-6ID]");
                switch (option) {
                    case "I" -> launchCoinMenu();
                    case "D" -> exit = true;
                    default -> buyProduct(option);
                }
            } catch (Exception e) {
                System.out.print("Error .: " + e.getMessage());
                pauseApp();
            }
        } while (!exit);
    }

    private static void launchCoinMenu() {
        boolean exit = false;

        do {
            try {
                System.out.printf(INSERT_COIN_MENU, formatCurrency(credit));
                String option = enterOption("[0-8]");
                if (option.equals("0")) {
                    exit = true;
                } else {
                    credit = insertCoin(option);
                }
            } catch (Exception e) {
                System.out.print("Error .: " + e.getMessage());
                pauseApp();
            }
        } while (!exit);
    }

    private static String enterOption(String regex) {
        String option = SCN.nextLine().strip().toUpperCase();

        if (option.isEmpty()) {
            throw new IllegalArgumentException("Selección nula ");
        }
        if (!option.matches(regex)) {
            throw new IllegalArgumentException("Opción incorrecta ");
        }
        return option;
    }

    private static void buyProduct(String option) {
        if (prices.get(option) > credit) {
            System.out.print("MSG ...: Saldo insuficiente ");
            pauseApp();
        } else {
            credit -= prices.get(option);
            System.out.print("MSG ...: Producto expedido ");
            pauseApp();
        }
    }

    private static double insertCoin(String option) {
        switch (option) {
            case "1" -> credit += 0.01;
            case "2" -> credit += 0.02;
            case "3" -> credit += 0.05;
            case "4" -> credit += 0.10;
            case "5" -> credit += 0.20;
            case "6" -> credit += 0.50;
            case "7" -> credit += 1;
            case "8" -> credit += 2;
        }
        return credit;
    }

    private static String formatCurrency(double value) {
        return NumberFormat.getCurrencyInstance().format(value);
    }

    private static void pauseApp() {
        SCN.nextLine();
    }
}

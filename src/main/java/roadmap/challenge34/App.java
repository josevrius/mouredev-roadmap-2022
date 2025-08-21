package roadmap.challenge34;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            AÑO CHINO
            =========""";

    private static final String[] HEAVENLY_STEMS = {
            "Madera (Yan)", "Madera (Yin)",
            "Fuego (Yan)", "Fuego (Yin)",
            "Tierra (Yan)", "Tierra (Yin)",
            "Metal (Yan)", "Metal (Yin)",
            "Agua (Yan)", "Agua (Yin)"
    };

    private static final String[] EARTHLY_BRANCHES = {
            "de la Rata", "del Buey", "del Tigre", "del Conejo", "del Dragón", "de la Serpiente",
            "del Caballo", "de la Cabra", "del Mono", "del Gallo", "del Perro", "del Jabalí"
    };

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            int year = enterYear();
            String chineseZodiac = getChineseZodiac(year);
            System.out.println("Zodiaco : " + chineseZodiac);
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static int enterYear() {
        Pattern validYears = Pattern.compile("60[4-9]|[6-9][1-9][0-9]|[1-9][0-9][0-9][0-9]");

        System.out.print("Año ....: ");
        String year = SCN.nextLine().strip();

        if (!validYears.matcher(year).matches()) {
            throw new IllegalArgumentException("Año no válido");
        }
        return Integer.parseInt(year);
    }

    private static String getChineseZodiac(int year) {
        int sexagenaryYear = (year - 3) % 60;
        int stemIndex = sexagenaryYear % 10;
        int branchIndex = sexagenaryYear % 12;

        if (stemIndex == 0) stemIndex = 10;
        if (branchIndex == 0) branchIndex = 12;

        String earthlyBranch = EARTHLY_BRANCHES[branchIndex - 1];
        String heavenlyStem = HEAVENLY_STEMS[stemIndex - 1];

        return String.format("Año %s de %s", earthlyBranch, heavenlyStem);
    }
}

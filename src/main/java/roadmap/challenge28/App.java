package roadmap.challenge28;

import java.util.Arrays;

public final class App {

    private static final String HEADER = """
            
            VECTORES ORTOGONALES
            ====================""";

    public static void main(String[] args) {
        int[] v1 = {1, 2};
        int[] v2 = {-2, 1};

        System.out.println(HEADER);
        try {
            System.out.println("Vector 1 ...: " + Arrays.toString(v1));
            System.out.println("Vector 2 ...: " + Arrays.toString(v2));
            boolean orthogonal = checkOrthogonal(v1, v2);
            System.out.println("Ortogonales : " + (orthogonal ? "SI" : "NO"));
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static boolean checkOrthogonal(int[] v1, int[] v2) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException("Fallo al cargar los vectores");
        }
        if (v1.length != 2 || v2.length != 2) {
            throw new IllegalArgumentException("Vectores no válidos");
        }
        return v1[0] * v2[0] + v1[1] * v2[1] == 0;
    }
}

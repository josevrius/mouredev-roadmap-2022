package org.jvrb.roadmap.exercise42;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class App42 {

    private static final String HEADER = """
            
            LEY DE OHM
            ==========""";

    public static void main(String[] args) {
        Double v = 3.125;
        Double i = null;
        Double r = 2.0;

        try {
            System.out.println(HEADER);
            calculateOhm(v, i, r);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void calculateOhm(Double v, Double i, Double r) {
        NumberFormat input = NumberFormat.getNumberInstance();
        NumberFormat output = new DecimalFormat("0.00"); // Dígitos obligatorios

        if (v == null && i != null && r != null && r > 0.0) {
            System.out.println("Intensidad .: " + input.format(i) + "A");
            System.out.println("Resistencia : " + input.format(r) + "Ω");
            System.out.println("Voltaje ....: " + output.format(i * r) + "V");
        } else if (v != null && i == null && r != null && r > 0.0) {
            System.out.println("Voltaje ....: " + input.format(v) + "V");
            System.out.println("Resistencia : " + input.format(r) + "Ω");
            System.out.println("Intensidad .: " + output.format(v / r) + "A");
        } else if (v != null && i != null && r == null) {
            System.out.println("Voltaje ....: " + input.format(v) + "V");
            System.out.println("Intensidad .: " + input.format(i) + "A");
            System.out.println("Resistencia : " + output.format(v / i) + "Ω");
        } else {
            throw new IllegalArgumentException("Valores no válidos");
        }
    }
}

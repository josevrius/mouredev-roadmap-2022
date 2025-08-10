package org.jvrb.roadmap.exercise21;

import java.text.NumberFormat;

public class App {

    private static final String HEADER = """
            
            PARANDO EL TIEMPO
            =================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        double sum = sumAfterDelay(5, 3.5, 6);
        System.out.println("Resultado : " + NumberFormat.getNumberInstance().format(sum));
    }


    private static double sumAfterDelay(double n1, double n2, int delaySeconds) {
        System.out.println("Suma .....: " + NumberFormat.getNumberInstance().format(n1) + " + " + NumberFormat.getNumberInstance().format(n2));
        System.out.print("Esperando : ");

        for (int i = 1; i <= delaySeconds; i++) {
            System.out.print(i > 1 ? ", " + i : i);
            if (i == delaySeconds) System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return n1 + n2;
    }
}

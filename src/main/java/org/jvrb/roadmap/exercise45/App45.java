package org.jvrb.roadmap.exercise45;

public final class App45 {

    private static final String HEADER = """
            
            BUMERANES
            =========""";

    public static void main(String[] args) {
        int[] sequence = {5, 3, 5, 7, 8, 7, 2, 2, 2, 4, 2, 4};

        System.out.println(HEADER);
        showNumbers(sequence);
        int boomerangsCounter = countBoomerangs(sequence);
        System.out.println("Total ....: " + boomerangsCounter);
    }

    private static void showNumbers(int[] sequence) {
        System.out.print("Secuencia : ");

        if (sequence != null && sequence.length > 0) {
            for (int i = 0; i < sequence.length; i++) {
                System.out.printf("%d%s", sequence[i], i < sequence.length - 1 ? " " : "\n");
            }
        } else {
            System.out.println();
        }
    }

    private static int countBoomerangs(int[] sequence) {
        int count = 0;
        System.out.print("Bumeranes : ");

        if (sequence != null && sequence.length > 2) {
            for (int i = 0; i < sequence.length - 2; i++) {
                if (sequence[i] != sequence[i + 1] && sequence[i] == sequence[i + 2]) {
                    System.out.printf("%s🪃 %d %d %d", i == 0 ? "" : " ", sequence[i], sequence[i + 1], sequence[i + 2]);
                    count++;
                }
            }
        }
        System.out.println();
        return count;
    }
}

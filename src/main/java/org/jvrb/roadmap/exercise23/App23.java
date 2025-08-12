package org.jvrb.roadmap.exercise23;

import java.util.TreeSet;

public class App23 {

    private static final String HEADER = """
            
            CONJUNTOS
            =========""";

    public static void main(String[] args) {
        char[] array1 = {'A', '2', 'U', '&'};
        char[] array2 = {'A', '2', 'C'};

        System.out.println(HEADER);
        printArray(array1, "Conjunto 1 : ");
        printArray(array2, "Conjunto 2 : ");
        TreeSet<Character> combination = combineArrays(array1, array2, false);
        printSet(combination);
    }

    // Usar "Boolean" en lugar de "boolean" para el filtro permite valor null
    private static TreeSet<Character> combineArrays(char[] array1, char[] array2, Boolean commons) {
        TreeSet<Character> s1 = convertToSet(array1);
        TreeSet<Character> s2 = convertToSet(array2);
        TreeSet<Character> result = new TreeSet<>();

        if (commons == null) {
            result.addAll(s1);
            result.addAll(s2);
            System.out.print("Combinados : ");
        } else if (commons) {
            result.addAll(s1);
            result.retainAll(s2);
            System.out.print("Comunes ...: ");
        } else {
            result.addAll(s1);
            result.removeAll(s2);
            s2.removeAll(s1);
            result.addAll(s2);
            System.out.print("No comunes : ");
        }
        return result;
    }

    // Sobrecarga sin filtro
    private static TreeSet<Character> combineArrays(char[] array1, char[] array2) {
        return combineArrays(array1, array2, null);
    }

    private static TreeSet<Character> convertToSet(char[] array) {
        TreeSet<Character> set = new TreeSet<>();

        for (char c : array) {
            set.add(c);
        }
        return set;
    }

    private static void printArray(char[] array, String msg) {
        System.out.printf(msg);

        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void printSet(TreeSet<Character> set) {
        for (Character c : set) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

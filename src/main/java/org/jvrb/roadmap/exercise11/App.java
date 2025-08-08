package org.jvrb.roadmap.exercise11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static final String HEADER = """
            
            EXPRESIONES BALANCEADAS
            =======================
            Expresión .:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            String expression = enterExpression();
            System.out.printf("Balanceada : %s%n", isBalanced(expression) ? "SI" : "NO");
        } catch (Exception e) {
            System.out.println("Error .....: " + e.getMessage());
        }
    }

    private static String enterExpression() {
        String expression = new Scanner(System.in).nextLine().strip();

        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        }
        return expression;
    }

    private static boolean isBalanced(String expression) {
        Map<Character, Character> delimiters = Map.ofEntries(
                Map.entry('(', ')'),
                Map.entry('{', '}'),
                Map.entry('[', ']')
        );

        List<Character> stack = new ArrayList<>();

        for (char character : expression.toCharArray()) {
            if (delimiters.containsKey(character)) {
                stack.add(delimiters.get(character));
            } else if (delimiters.containsValue(character)) {
                if (!stack.isEmpty() && stack.getLast() == character) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

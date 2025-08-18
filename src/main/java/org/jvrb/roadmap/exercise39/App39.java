package org.jvrb.roadmap.exercise39;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class App39 {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            BINARIO A DECIMAL
            ================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        try {
            String binary = enterBinary();
            int decimal = convertBinaryToDecimal(binary);
            System.out.println("Decimal : " + decimal);
        } catch (Exception e) {
            System.out.println("Error ..: " + e.getMessage());
        }
    }

    private static String enterBinary() {
        Pattern validInput = Pattern.compile("[01]+");

        System.out.print("Binario : ");
        String input = SCN.nextLine().strip();

        if (!validInput.matcher(input).matches()) {
            throw new InputMismatchException("No es número binario válido");
        }
        return input;
    }

    private static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        int power = 1;

        for (int i = binary.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(binary.charAt(i));
            decimal += digit * power;
            power *= 2;
        }
        return decimal;
    }
}

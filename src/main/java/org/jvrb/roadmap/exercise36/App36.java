package org.jvrb.roadmap.exercise36;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class App36 {

    private enum Type {
        FIRE(0), WATER(1), PLANT(2), ELECTRIC(3);

        private final int index;

        Type(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    private static final double[][] effectivityTable = {
            {0.5, 0.5, 2.0, 1.0},
            {2.0, 0.5, 0.5, 1.0},
            {0.5, 2.0, 0.5, 1.0},
            {1.0, 2.0, 0.5, 0.5}
    };

    private static final String HEADER = """
            
            BATALLA POKEMON
            ===============""";

    public static void main(String[] args) {
        Type attackType = Type.FIRE;
        Type defenseType = Type.WATER;
        int attack = 62;
        int defense = 33;

        System.out.println(HEADER);
        try {
            System.out.printf("Atacante ...: %s (%d)\n", attackType, attack);
            System.out.printf("Defensor ...: %s (%d)\n", defenseType, defense);
            BigDecimal damage = calculateDamage(attackType, defenseType, attack, defense);
            System.out.println("Daño .......: " + damage);
        } catch (Exception e) {
            System.out.println("Error ......: " + e.getMessage());
        }
    }

    private static BigDecimal calculateDamage(Type attacker, Type defender, double attack, double defense) {
        if (attack < 1 || attack > 100 || defense < 1 || defense > 100) {
            throw new IllegalArgumentException("El ataque y la defensa deben estar entre 1 y 100");
        }

        double effectiveDamage = effectivityTable[attacker.getIndex()][defender.getIndex()];
        String effectiveType;

        if (effectiveDamage == 2) {
            effectiveType = "\u001B[31mMuy efectivo\u001B[0m";
        } else if (effectiveDamage == 0.5) {
            effectiveType = "\u001B[33mPoco efectivo\u001B[0m";
        } else {
            effectiveType = "\u001B[32mNeutral\u001B[0m";
        }
        System.out.println("Efectividad : " + effectiveType);

        return new BigDecimal(50 * attack / defense * effectiveDamage).setScale(2, RoundingMode.HALF_UP);
    }
}

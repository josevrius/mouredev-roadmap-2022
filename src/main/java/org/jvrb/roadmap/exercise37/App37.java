package org.jvrb.roadmap.exercise37;

import java.util.Map;

public final class App37 {

    private enum KindRace {
        HARFOOT(1), SOUTHERNER(2), DWARF(3), NUMENOREAN(4), ELF(5);

        private final int power;

        KindRace(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    private enum EvilRace {
        SOUTHERNER(2), ORC(2), GOBLIN(2), WARG(3), TROLL(5);

        private final int power;

        EvilRace(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    private static final String HEADER = """
            
            BATALLA EN LA TIERRA MEDIA
            ==========================""";

    public static void main(String[] args) {
        Map<KindRace, Integer> kindArmy = Map.ofEntries(
                Map.entry(KindRace.HARFOOT, 0),
                Map.entry(KindRace.SOUTHERNER, 0),
                Map.entry(KindRace.DWARF, 0),
                Map.entry(KindRace.NUMENOREAN, 0),
                Map.entry(KindRace.ELF, 0)
        );
        Map<EvilRace, Integer> evilArmy = Map.ofEntries(
                Map.entry(EvilRace.SOUTHERNER, 0),
                Map.entry(EvilRace.ORC, 0),
                Map.entry(EvilRace.GOBLIN, 0),
                Map.entry(EvilRace.WARG, 0),
                Map.entry(EvilRace.TROLL, 0)
        );

        System.out.println(HEADER);
        System.out.println("Ejercito del Bien : " + kindArmy);
        System.out.println("Ejercito del Mal .: " + evilArmy);
        showResult(kindArmy, evilArmy);
    }

    private static void showResult(Map<KindRace, Integer> kindArmy, Map<EvilRace, Integer> evilArmy) {
        int kindArmyPower = 0;
        int evilArmyPower = 0;

        for (Map.Entry<KindRace, Integer> entry : kindArmy.entrySet()) {
            kindArmyPower += entry.getKey().getPower() * entry.getValue();
        }

        for (Map.Entry<EvilRace, Integer> entry : evilArmy.entrySet()) {
            evilArmyPower += entry.getKey().getPower() * entry.getValue();
        }

        System.out.print("Resultado ........: ");
        if (kindArmyPower > evilArmyPower) {
            System.out.println("Gana el Bien");
        } else if (kindArmyPower < evilArmyPower) {
            System.out.println("Gana el Mal");
        } else {
            System.out.println("Empate");
        }
    }
}

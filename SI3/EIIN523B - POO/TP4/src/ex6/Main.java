package ex6;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD4 - ex3                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        ArrayList<Pokemon> packet = new ArrayList<>();

        Pokemon salameche = new Pokemon("SALAMECHE", Pokemon.Type.FEU, 10, 4, 5);
        Pokemon oddish = new Pokemon("ODDISH", Pokemon.Type.PLANTE, 10, 6, 2);
        Pokemon venonat = new Pokemon("VENONAT", Pokemon.Type.INSECTE, 10, 9, 1);
        Pokemon tentacouille = new Pokemon("TENTACOOL", Pokemon.Type.EAU, 10, 0, 0);

        packet.add(salameche);
        packet.add(oddish);
        packet.add(venonat);
        packet.add(tentacouille);

        System.out.println("This is packet contains:");

        for (Pokemon pokemon : packet){

            System.out.println(pokemon.getName());

        }

        /*ODDISH (life=10, attack=6, defense=2) vs SALAMECHE (life=10, attack=4, defense=5)
            ===> ODDISH (life=8, attack=6, defense=2) and SALAMECHE (life=9, attack=4, defense=5)
        VENONAT (life=10, attack=9, defense=1) vs SALAMECHE (life=9, attack=4, defense=5)
            ===> VENONAT (life=7, attack=9, defense=1) and SALAMECHE (life=5, attack=4, defense=5)
        SALAMECHE (life=5, attack=4, defense=5) vs VENONAT (life=7, attack=9, defense=1)
            ===> SALAMECHE (life=1, attack=4, defense=5) and VENONAT (life=4, attack=9, defense=1)
        ODDISH (life=8, attack=6, defense=2) vs SALAMECHE (life=1, attack=4, defense=5)
        SALAMECHE is dead!
            ===> ODDISH (life=6, attack=6, defense=2)
        ODDISH (life=6, attack=6, defense=2) vs VENONAT (life=4, attack=9, defense=1)
        ODDISH is dead!
        VENONAT is dead!
            ===> ODDISH (life=6, attack=6, defense=2)*/

        for (int i = 0; i < 10 && packet.size() >= 2; ++i){

            Collections.shuffle(packet);

            Pokemon card1 = packet.get(0);
            Pokemon card2 = packet.get(1);

            System.out.println(card1 + " vs " + card2);

            Pokemon.vs(card1, card2);

            if (card1.isKo()){

                packet.remove(card1);

            }

            if (card2.isKo()){

                packet.remove(card2);

            }
        }
    }
}

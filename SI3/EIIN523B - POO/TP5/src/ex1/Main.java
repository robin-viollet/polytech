package ex1;

import java.util.Collections;

public class Main {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD5 - ex1                                          *\n" +
                "* ----------------------------------------------------------- *\n");
        System.out.println("This is packet contains:");

        Packet packet = new Packet();

        System.out.println(packet);

        /*for (int i = 0; i < 10 && packet.size() >= 2; ++i){

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
        }*/
    }
}

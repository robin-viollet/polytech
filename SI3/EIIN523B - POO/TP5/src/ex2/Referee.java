package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public Referee(){

        packet = new Packet();

        packet.add(Pokemon.SALAMECHE);
        packet.add(Pokemon.ODDISH);
        packet.add(Pokemon.VENONAT);
        packet.add(Pokemon.TENTACOOL);

        Collections.shuffle(packet.packet);

    }

    private final Packet packet;

    public Packet getPacket(){

        return packet;

    }

    public void displayResultBattle(int resultBattle, Player player1, Player player2){

        Pokemon card1 = player1.getCard();
        Pokemon card2 = player2.getCard();

        if (card1.getLife() == 0 && card2.getLife() == 0){

            System.out.println("Joueur [" + player1 + "] lose: -->" + card1.name() + " is dead!");
            System.out.println("Joueur [" + player2 + "] lose: -->" + card2.name() + " is dead!");
            System.out.println("\t===> two loosers!");

        } else if (card1.getLife() == 0){

            System.out.println("Joueur [" + player1 + "] lose: -->" + card1.name() + " is dead!");
            System.out.println("\t===> winner is: " + card2);

        } else if (card2.getLife() == 0){

            System.out.println("Joueur [" + player2 + "] lose: -->" + card2.name() + " is dead!");
            System.out.println("\t===> winner is: " + card1);

        } else {

            System.out.println("\t===> nobody loose: " + card1 + " and " + card2);

        }

        System.out.println();

    }

    public void displayHandlePacket(){

        System.out.println("This is packet contains:");
        System.out.println(packet);

    }

    public void displayChallenge(Player player1, Player player2){

        Pokemon card1 = player1.getCard();
        Pokemon card2 = player2.getCard();

        System.out.println(card1 + " vs " + card2);

    }

    public void distribute(Player player1, Player player2){

        Pokemon[] cards = packet.getTwo();

        player1.setCard(cards[0]);
        player2.setCard(cards[1]);

    }

    public class Packet {
        public Packet(){

            this.packet = new ArrayList<>();

        }

        private final List<Pokemon> packet;

        public void add(Pokemon pokemon){

            packet.add(pokemon);

        }

        public void remove(Pokemon pokemon){

            packet.remove(pokemon);

        }

        public Pokemon getOne(){

            return packet.get(0);

        }

        public Pokemon[] getTwo(){

            return new Pokemon[]{packet.get(0), packet.get(1)};

        }

        @Override
        public String toString(){

            StringBuilder s = new StringBuilder();

            for (Pokemon pokemon : packet){

                s.append(pokemon.name()).append('\n');

            }

            return s.toString();

        }
    }
}

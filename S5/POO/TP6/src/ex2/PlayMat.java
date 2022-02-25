package ex2;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayMat {

    private static final List<Player> players = new ArrayList<>();
    private static final List<Card> cards = new ArrayList<>();
    private static final List<Card> savedCards = new ArrayList<>();

    static void add(Card card, Player player){

        players.add(player);
        cards.add(card);

        System.out.print(player.getName() + " play " + card + (player.hasCards() ? "" : " (last card)"));

    }

    static void remove(Player player){

        cards.remove(players.indexOf(player));
        players.remove(player);

    }

    public static void saveCards(List<Player> warPlayers){

        for (int i = 0; i < players.size(); i++){

            Player player = players.get(i);
            Card playerCard = cards.get(i);

            if (!warPlayers.contains(player)){

                player.pushCard(cards.get(i));

            } else {

                savedCards.add(playerCard);

            }
        }

        clear();

    }

    public static List<Player> getPlayers(){

        return players;

    }

    public static List<Card> getCards(){

        return cards;

    }

    public static List<Card> getAllCards(){

        List<Card> tempCards = new ArrayList<>();

        tempCards.addAll(cards);
        tempCards.addAll(savedCards);

        return tempCards;

    }

    public static void emptyCards(){

        cards.clear();
        savedCards.clear();

    }

    public static int size(){

        //TODO ?
        return 0;

    }

    static void displayRound(){

        //TODO Finish

    }

    static void clear(){

        players.clear();
        cards.clear();

    }
}

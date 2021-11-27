package ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Referee {

    public void distribute(int nbCards, Deck deck, List<Player> players){

        for (Player player : players){
            for (int i = 0; i < nbCards; i++){

                player.pushCard(deck.pop());

            }
        }
    }

    public Player getRoundWinner(){

        List<Card> cards = PlayMat.getCards();
        ArrayList<Card> sortedCards = new ArrayList<>(cards);

        sortedCards.sort(Comparator.reverseOrder());

        return PlayMat.getPlayers().get(cards.indexOf(sortedCards.get(0)));

    }

    public List<Player> getWarPlayers(){

        ArrayList<Player> warPlayers = new ArrayList<>();

        List<Card> cards = PlayMat.getCards();
        List<Player> players = PlayMat.getPlayers();

        for (int i = 0; i < cards.size(); i++){
            for (int j = 0; j < cards.size(); j++){
                if (i != j && cards.get(i).equals(cards.get(j))){

                    if (!warPlayers.contains(players.get(i))){

                        warPlayers.add(players.get(i));

                    }

                    if (!warPlayers.contains(players.get(j))){

                        warPlayers.add(players.get(j));

                    }
                }
            }
        }

        return warPlayers;

    }

    public void givePlaymateCardsToTheWinner(Player roundWinner){

        PlayMat.getAllCards().forEach(roundWinner::pushCard);
        PlayMat.emptyCards();

    }

    public void updatePlayerList(List<Player> players){

        players.removeIf(player -> !player.hasCards());

    }

    public void askPlayerToShowHisCards(Player player){

        player.showHand();

    }

    public void movePlayersWarCardToTempoCardlistAndPlayAgain(List<Player> warPlayers, List<Player> currentPlayers){

        PlayMat.saveCards(warPlayers);

    }

    public void cheat(List<Player> players, Deck deck){



    }
}

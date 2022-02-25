package ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Referee referee;

    public static void main(String[] args){

        try {

            Deck deck = new Deck(1, Deck.DECK52);

            System.out.println(deck);

            List<Player> players = new ArrayList<>();

            players.add(new Player("Fred"));
            players.add(new Player("Daphné"));
            players.add(new Player("Véra"));
            players.add(new Player("Samy"));

            referee = new Referee();

            referee.distribute(4, deck, players);

            referee.cheat(players.subList(0, 2), deck);

            while (players.size() > 1){

                System.out.println("-------------------------\n");

                for (Player player : players){

                    PlayMat.add(player.popCard(), player);
                    System.out.print(" --> hand cards are: ");
                    referee.askPlayerToShowHisCards(player);

                }

                PlayMat.displayRound();

                List<Player> warPlayers = referee.getWarPlayers();

                while (warPlayers.size() > 1){

                    System.out.println("REFEREE says: >>>>>>>>>>> getWarPlayers <<<<<<<<<<<< beetween " + warPlayers);

                    referee.movePlayersWarCardToTempoCardlistAndPlayAgain(warPlayers, players);

                    for (Player warPlayer : warPlayers){

                        PlayMat.add(warPlayer.popCard(), warPlayer);
                        System.out.print(" --> hand cards are: ");
                        referee.askPlayerToShowHisCards(warPlayer);

                    }

                    //TODO Display round
                    referee.updatePlayerList(players);

                    warPlayers = referee.getWarPlayers();

                }

                Player winner = referee.getRoundWinner();

                System.out.println("Round winners is: " + winner);

                referee.givePlaymateCardsToTheWinner(winner);
                referee.updatePlayerList(players);

                for (Player player : players){

                    referee.askPlayerToShowHisCards(player);

                }

                PlayMat.clear();

            }

            //TODO fix
            System.out.println("\n-------------------------");
            System.out.println("REFEREE says: congratulation " + players.get(0));

        } catch (DeckException e){

            e.printStackTrace();

        }
    }
}

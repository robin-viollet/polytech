package ex1;

public class Main {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD5 - ex2                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        Player fred = new Player("fred");
        Player sandrine = new Player("sandrine");

        Referee.init();
        Referee.displayHandlePacket();

        for (int i = 0; i < 10; i++){

            Referee.distribute(fred, sandrine);

            if (fred != null && fred.getCard() != null && sandrine != null && sandrine.getCard() != null){

                Referee.displayChallenge(fred, sandrine);

                int battleValue = Battle.play(fred, sandrine);

                Referee.displayResultBattle(battleValue, fred, sandrine);

            }
        }
    }
}

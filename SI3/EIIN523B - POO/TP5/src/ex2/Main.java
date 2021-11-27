package ex2;

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

        Referee referee = new Referee();

        referee.displayHandlePacket();

        Battle battle = new Battle(referee.getPacket());

        for (int i = 0; i < 10; i++){

            referee.distribute(fred, sandrine);

            if (fred != null && fred.getCard() != null && sandrine != null && sandrine.getCard() != null){

                referee.displayChallenge(fred, sandrine);

                int battleValue = battle.play(fred, sandrine);

                referee.displayResultBattle(battleValue, fred, sandrine);

            }
        }
    }
}

package ex3;

public class Main {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD5 - ex3                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        Mastermind mastermind = new Mastermind(3, 4);

        mastermind.displayUnusedGuesses();
        System.out.println();
        mastermind.displayPossibleScore();

    }
}

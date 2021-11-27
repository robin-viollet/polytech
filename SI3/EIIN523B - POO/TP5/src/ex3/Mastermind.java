package ex3;

import java.util.ArrayList;
import java.util.List;

public class Mastermind {

    public Mastermind(int pegs, int colors){

        this.pegs = pegs;
        this.colors = colors;

        guesses = new ArrayList<>();
        scores = new ArrayList<>();

        for (int i = 1; i <= colors; i++){
            for (int j = 1; j <= colors; j++){
                for (int k = 1; k <= colors; k++){
                    //for (int l = 1; l <= colors; l++){

                        guesses.add("" + i + j + k);

                    //}
                }
            }
        }

        for (int i = 0; i <= pegs; i++){
            for (int j = Math.max(0, colors - pegs + 1); j <= pegs; j++){

                if (i + j <= pegs){

                    scores.add("(" + i + ", " + j + ")");

                }
            }
        }
    }

    private int pegs;
    private int colors;
    private List<String> guesses;
    private List<String> scores;

    public void displayUnusedGuesses(){

        for (String guess : guesses){

            System.out.println(guess);

        }

        System.out.println("total: " + guesses.size() + " values");

    }

    public void displayPossibleScore(){

        for (String score : scores){

            System.out.println(score);

        }

        System.out.println("total: " + scores.size() + " values");

    }
}

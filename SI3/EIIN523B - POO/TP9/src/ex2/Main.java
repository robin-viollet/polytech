package ex2;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args){

        Scrabble scrabble = new Scrabble();

        System.out.println("question1: score de \"BONJOUR\"=" + scrabble.computeScore.apply("BONJOUR"));// 16

        System.out.println(scrabble.shakespeareLines.stream()
                .collect(groupingBy(scrabble.computeScore, Collectors.counting())));

        /*question2: {1=20, 2=79, 3=168, 4=452, 5=750, 6=1357, 7=1905, 8=2362, 9=2704, 10=2866,
                11=2851, 12=2812, 13=2406, 14=2044, 15=1687, 16=1328, 17=981, 18=738, 19=487, 20=371,
                21=257, 22=174, 23=105, 24=79, 25=62, 26=39, 27=24, 28=22, 29=10, 30=9, 31=6, 32=3, 33=3,
                34=2, 36=1, 40=2}*/

        System.out.println(scrabble.shakespeareLines.stream()
                .filter(s -> scrabble.computeScore.apply(s) > 36)
                .collect(groupingBy(scrabble.computeScore)));

        /*question3: {40=[honorificabilitudinitatibus, Nebuchadnezzar]}*/

        /*System.out.println(scrabble.shakespeareLines.stream()
                .filter(s -> scrabble.scrabbleLines.contains(s))
                .filter(s -> scrabble.computeScore.apply(s) > 28)
                .collect(groupingBy(scrabble.computeScore)));*/

        /*question4: {33=[whizzing], 29=[buzzards]}*/

        /*System.out.println(scrabble.shakespeareLines.stream()
                .filter(s -> scrabble.availableWord.test(s))
                .filter(s -> scrabble.computeScore.apply(s) > 28)
                .collect(groupingBy(scrabble.computeScore)));*/

        /*question5: {2=26, 3=74, 4=241, 5=426, 6=808, 7=1145, 8=1422, 9=1602, 10=1646, 11=1505,
                12=1315, 13=990, 14=700, 15=531, 16=353, 17=233, 18=119, 19=65, 20=40, 21=14, 22=10,
                23=7, 24=5, 25=1, 26=1}*/


        /*question6: {25=[quickly], 26=[squeezes]}*/



        /*question7: nb Blank = 1*/
        System.out.println(scrabble.nbBlankNeeded.apply("buzzards"));

        /*question8: score Buzzards => (old) 29 (new) 19*/
        System.out.println("question8: score Buzzards => (old) " + scrabble.computeScore.apply("Buzzards") + " (new) " + scrabble.computeScoreV2.apply("Buzzards"));

        /*question9: {19=[buzzards], 20=[hazarded, vizarded], 23=[whizzing]}*/

        System.out.println(scrabble.shakespeareLines.stream()
                .filter(s -> scrabble.availableWord.test(s))
                .filter(s -> scrabble.nbBlankNeeded.apply(s) > 0)
                .filter(s -> scrabble.computeScore.apply(s) > 18)
                .toList());

    }
}

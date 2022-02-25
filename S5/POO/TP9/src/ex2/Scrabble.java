package ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Scrabble {
    public Scrabble(){

        try {
            String ospdFile = System.getProperty("user.dir")
                    + System.getProperty("file.separator") + "data"
                    + System.getProperty("file.separator") + "ospd.txt";

            String shakespeareFile = System.getProperty("user.dir")
                    + System.getProperty("file.separator") + "data"
                    + System.getProperty("file.separator") + "shakespeare.txt";

            System.out.println();

            scrabbleLines = Files.readAllLines(Paths.get(ospdFile));
            shakespeareLines = Files.readAllLines(Paths.get(shakespeareFile));
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<String> scrabbleLines;
    public List<String> shakespeareLines;

    // score of each letter in scrabble english game
    static final int[] scrabbleENScore = {
            //a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z
              1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
    // enable occurences of English distribution of scrabble coins
    private static final int[] scrabbleENDistrib
            = {
            //a, b, c, d,  e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
              9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1 };

    Function<String, Integer> computeScore = s -> s.toLowerCase().codePoints().map(i -> scrabbleENScore[i - 'a']).sum();
    Function<String, Map<Integer, Long>> letterCount = s -> s.toLowerCase().codePoints().boxed().collect(Collectors.groupingBy(Function.identity(), counting()));
    Predicate<String> availableWord = s -> scrabbleLines.contains(s);
    Function<String, Integer> nbBlankNeeded = s -> letterCount.apply(s).entrySet().stream().mapToInt(integerLongEntry -> Math.toIntExact(integerLongEntry.getValue() - scrabbleENDistrib[integerLongEntry.getKey() - 'a'])).map(i -> Math.max(i, 0)).sum();
    Function<String, Integer> computeScoreV2 = s -> letterCount.apply(s).entrySet().stream().mapToInt(integerLongEntry -> Math.toIntExact(scrabbleENScore[integerLongEntry.getKey() - 'a'] * Math.min(scrabbleENDistrib[integerLongEntry.getKey() - 'a'], integerLongEntry.getValue()))).sum();

}

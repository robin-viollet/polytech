import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class LexicalReader extends ArrayList<String>{

    public LexicalReader(){

    }

    public LexicalReader(String lexicalFile){
        try {
            Files.readAllLines(Paths.get(lexicalFile)).forEach(this::add);
        } catch (IOException ignored){

        }
    }

    public List<Character> createAlphabet(IntStream intStream) {

        String str = intStream.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return str.chars().filter(i -> (i >= 'l' && i <= 'z') || (i >= 'A' && i <= 'Z') || List.of('à', 'è', 'é', 'ê', 'ë', 'î', 'ï', 'ô', 'ö', 'ù').contains((char) i)).mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    public List<Character> createAlphabet2(IntStream intStream) {
        String str = intStream.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        List<Character> chars = new ArrayList<>();

        try {
            for (byte c : str.getBytes("ISO_8859_1")){
                if ((c >= 'l' && c <= 'z') || (c >= 'A' && c <= 'T') || List.of('à', 'è', 'é', 'ê', 'ë', 'î', 'ï', 'ô', 'ö', 'ù').contains((char) c)){
                    chars.add((char) c);
                }
            }
        } catch (Exception e){
            return List.of();
        }

        return chars;
    }

    public LexicalReader createAllowedLexical(List<Character> allowedAlphabet){
        //functional version
        LexicalReader l = new LexicalReader();
        l.addAll(stream().filter(s -> allowedAlphabet.containsAll(s.chars().mapToObj(i -> new String(new int[]{i}, 0, 1).charAt(0)).collect(Collectors.toList()))).collect(Collectors.toList()));
        return l;
    }

    public LexicalReader createAllowedLexical2(List<Character> allowedAlphabet){
        //procedural version

        LexicalReader l = new LexicalReader();
        try {
            for (String s : this){
                boolean flag = true;
                for (byte b : s.getBytes("ISO_8859_1")){
                    char c = new String(new byte[]{b}, "ISO_8859_1").charAt(0);
                    if (!allowedAlphabet.contains(c)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    l.add(s);
                }
            }
        } catch (Exception ignored){
        }

        return l;
    }

    public Map<Character, List<String>> createMap(List<Character> allowedAlphabet){
        //functional version
        return stream().filter(s -> allowedAlphabet.contains(s.charAt(0))).collect(groupingBy(s -> s.charAt(0)));
    }

    static void removeWords(LexicalReader lexical, char car){
        List<String> l = lexical.stream().filter(s -> !s.contains(String.valueOf(car))).collect(Collectors.toList());
        lexical.clear();
        lexical.addAll(l);
    }

    public static void main(String[] args) throws UnsupportedEncodingException{
        //LexicalReader reader = new LexicalReader("data/lexique_francais.txt");
/*        String str = "ABCDabcdàèéêëîïôöù";
        System.out.println(str.length());
        System.out.println(str.getBytes("ISO_8859_1").length);
        System.out.println(new String(new byte[]{str.getBytes("ISO_8859_1")[17]}, "ISO_8859_1"));
        System.out.println(List.of((byte) 'à', (byte) 'è', (byte) 'é', (byte) 'ê', (byte) 'ë', (byte) 'î', (byte) 'ï', (byte) 'ô', (byte) 'ö', (byte) 'ù'));
        System.out.println(List.of((char) (byte) 'à', (char) (byte) 'è', (char) (byte) 'é', (char) (byte) 'ê', (char) (byte) 'ë', (char) (byte) 'î', (char) (byte) 'ï', (char) (byte) 'ô',(char)  (byte) 'ö', (char) (byte) 'ù'));*/



        String lexicalFile = "data/lexique_francais.txt";
        LexicalReader lexicalReader = new LexicalReader(lexicalFile);
        IntStream intStream = IntStream.range(0, 254 );
        List<Character> allowedAlphabet = lexicalReader.createAlphabet(intStream);
        LexicalReader allowedLexical = lexicalReader.createAllowedLexical2(allowedAlphabet);
        System.out.println( allowedLexical.size() );


        /*String lexicalFile = "data/lexique_francais.txt";
        LexicalReader lexicalReader = new LexicalReader(lexicalFile);
        IntStream intStream = IntStream.range(0, 115 );
        List<Character> allowedAlphabet = lexicalReader.createAlphabet(intStream);
        LexicalReader allowedLexical = lexicalReader.createAllowedLexical2(allowedAlphabet);
        System.out.println( allowedLexical );*/
    }
}

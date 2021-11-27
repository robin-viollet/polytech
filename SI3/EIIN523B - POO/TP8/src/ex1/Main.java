package ex1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    static List<Humain> humains = Arrays.asList(
            new Humain("Rallo", "Fred", Arrays.asList("François", "Jean-Luc"), 51, new Date(), 106265486458L),
            new Humain("Lagaff", "Gaston", Arrays.asList("Luc"), 21, new Date(), 108265486458L),
            new Humain("Litovsky", "Igor", Arrays.asList("Gaston", "Léon", "Marcel"), 68, new Date(), 193265486458L),
            new Humain("Sanders", "Peter", Arrays.asList("Gaston", "Fred", "Joe"), 69, new Date(), 193265486458L),
            new Humain("Carron", "Catherine", Arrays.asList("Josette", "Monique", "Rose"), 60, new Date(), 193265486458L),
            new Humain("Carron", "Catherine", Arrays.asList("Josée", "Julie"), 57, new Date(), 242265486458L),
            new Humain("Lecat", "Rosa", Arrays.asList("Josette"), 67, new Date(), 206265486458L)
    );

    private static Predicate<Humain> isVeteran(){

        return humain -> humain.age >= 60;

    }

    private static Predicate<Humain> checkLastnameIsGaston(){

        return humain -> humain.Prenom.equals("Gaston");

    }

    private static Predicate<Humain> checkOtherLastnameIsGaston(){

        return checkOtherLastname("Gaston");

    }

    private static Predicate<Humain> checkOtherLastname(String lastname){

        return humain -> humain.autresPrenomList.contains(lastname);

    }

    private static Predicate<Humain> checkLastname(String lastname){

        return humain -> humain.Prenom.equals(lastname);

    }

    private static Predicate<Humain> checkLastnameOrOtherLastname(String lastname){

        return checkLastname(lastname).or(checkOtherLastname(lastname));

    }

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD8 - ex1                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        if (humains.stream().anyMatch(isVeteran())){

            System.out.println("Il y a au moins un humain de plus de 60 ans");

        }

        if (humains.stream().anyMatch(checkLastnameIsGaston())){

            System.out.println("Il y a au moins un humain prénommé Gaston");

        }

        if (humains.stream().anyMatch(checkOtherLastnameIsGaston())){

            System.out.println("Il y a des humain(s) sus-prénommé Gaston");

        }

        if (humains.stream().noneMatch(checkOtherLastname("Sandrine"))){

            System.out.println("Il aucun humain(s) sus-prénommé Sandrine");

        }

        System.out.println();
        System.out.println("Les vieux :");
        humains.stream().filter(isVeteran()).map(humain -> humain.Nom).forEach(System.out::println);

        System.out.println();
        System.out.println("Combien de vieux ?");
        System.out.println(humains.stream().filter(isVeteran()).map(humain -> humain.Nom).count());

        System.out.println();
        System.out.println("Combien de personne de plus de 55 ans");
        System.out.println(humains.stream().filter(humain -> humain.age > 55).map(humain -> humain.Nom).count());

        System.out.println();
        System.out.println("Numéro sécu des vieux :");
        humains.stream().filter(isVeteran()).map(humain -> humain.numeroSocial).forEach(System.out::println);

        System.out.println();
        System.out.println("Vieux prénoms :");
        System.out.println(humains.stream().filter(isVeteran()).map(humain -> humain.autresPrenomList).flatMap(Collection::stream).collect(Collectors.toList()));

        System.out.println();
        System.out.println("Vieux prénoms :");
        System.out.println(humains.stream().filter(isVeteran()).map(humain -> humain.autresPrenomList).flatMap(Collection::stream).distinct().collect(Collectors.toList()));

        System.out.println();
        System.out.println("Un Gaston :");
        humains.stream().filter(isVeteran()).filter(checkOtherLastnameIsGaston()).limit(1).map(humain -> humain.Nom).forEach(System.out::println);

        System.out.println();
        System.out.println("Une vielle Rosa :");
        humains.stream().filter(isVeteran()).filter(checkLastname("Rosa")).limit(1).map(humain -> humain.Nom).forEach(System.out::println);

        System.out.println();
        System.out.println("Une vielle josette :");
        humains.stream().filter(isVeteran()).filter(checkOtherLastname("Josette")).limit(1).map(humain -> humain.Nom).forEach(System.out::println);

        System.out.println();
        System.out.println("Les Fred :");
        System.out.println(humains.stream().filter(checkLastnameOrOtherLastname("Fred")).map(humain -> humain.Nom).collect(Collectors.toList()));

    }
}
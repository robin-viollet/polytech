package exercice2;

public class TestCapitale {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java – SI3                                               *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3   - ex2                                        *\n" +
                "* ----------------------------------------------------------- *");

        System.out.println("création de Nice...");

        Ville nice = new Ville("Nice", 1099);

        System.out.println(nice.description());

        System.out.println();
        System.out.println("création de Paris...");

        Ville paris = new Capitale("Paris", "FRANCE", 5555);

        System.out.println(paris.description());
        System.out.println();

        System.out.println("création de Londres...");

        Capitale londres = new Capitale("Londres", "ANGLETERRE");

        System.out.println(londres.description());

    }
}

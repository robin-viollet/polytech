package exercice3;

public class TestPatelin {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java - SI3                                               *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3   - ex3                                        *\n" +
                "* ----------------------------------------------------------- *");

        System.out.println("création de Nice...");

        Ville nice = new Ville("Nice", 1099);

        System.out.println(nice.description());
        System.out.println();

        System.out.println("création de Séranon...");

        Patelin seranon = new Patelin("Séranon");

        System.out.println(seranon.description());
        System.out.println();

        System.out.println("création de Ovignon...");

        Patelin ovignon = new Patelin("Ovignon", 344);

        System.out.println(ovignon.description());
        System.out.println();

        System.out.println("création de Lyon...");

        Patelin lyon = new Patelin("Lyon", 1001);
        System.out.println(lyon.description());

    }
}

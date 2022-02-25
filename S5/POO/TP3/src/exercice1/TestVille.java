package exercice1;

public class TestVille {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3 - ex1                                          *\n" +
                "* ----------------------------------------------------------- *\n" +
                "Au départ...");

        Ville[] villes = new Ville[5];
        int i = 0;

        System.out.println("Les Villes sont :");
        listVilles(villes);
        System.out.println();

        System.out.println("création d'une ville avec nom");
        System.out.println("Les Villes sont :");

        Ville vence = new Ville("Vence");
        villes[i] = vence;
        ++i;

        listVilles(villes);
        System.out.println();

        System.out.println("création d'une ville avec nom et nb d'ahabitants");

        Ville cagnessurmer = new Ville("Cagnes sur Mer", 453);
        villes[i] = cagnessurmer;
        ++i;

        System.out.println("Les Villes sont :");
        listVilles(villes);
        System.out.println();

        System.out.println("création d'une ville sans nom");

        Ville sansNom = new Ville();
        villes[i] = sansNom;

        System.out.println("création d'une ville avec nom");
        System.out.println("Les Villes sont :");

        Ville ville1 = new Ville("Ville");
        villes[i] = ville1;
        ++i;

        listVilles(villes);

        System.out.println("création d'une ville avec nom et nb d'ahabitants");

        Ville ville2 = new Ville("Ville2", 314);
        villes[i] = ville2;
        ++i;

        System.out.println("Les Villes sont :");
        listVilles(villes);
        System.out.println();

    }

    private static void listVilles(Ville[] villes){

        for (Ville ville : villes){

            if (ville != null){

                System.out.println("- " + ville.description());

            }
        }
    }
}

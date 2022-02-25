package exercice4;

public class Main {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD3 - ex4                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        //-- 1er jeu de tests
        System.out.println("1er jeu de tests");
        System.out.println("------------------------------------------------------------");

        Capitale c1 = new Capitale("Paris", "France");
        Ville v11 = (Ville) c1;
        Ville v12 = c1;

        // Capitale n'hérite pas de de Patelin
        //Patelin p1 = (Patelin) c1;
        //System.out.println ("\t- " + p1.getNom() + " " + p1.description());
        System.out.println ("- " + c1.description());
        System.out.println ("- " + v11.description());
        System.out.println ("- " + v12.description());
        System.out.println();

        //-- 2ème jeu de tests
        System.out.println("2ème jeu de tests");
        System.out.println("------------------------------------------------------------");

        Ville v21 = new Ville("Marseille");
        // Impossible de caster une Ville en Capitale car Ville n'hérite pas de Capitale
        //Capitale c2 = (Capitale) v21;
        Ville v22 = new Patelin("Marseille");
        Patelin p2 = (Patelin) v22;
        //System.out.println ("\t- " + c2.getNom() + " " + c2.description());
        System.out.println ("- " + v21.description());
        System.out.println ("- " + v22.description());
        System.out.println ("- " + p2.description());

    }
}

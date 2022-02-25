package ex4;

public class Test {

    public static void main(String[] args){

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD4 - ex1                                          *\n" +
                "* ----------------------------------------------------------- *");

        Ville[] tabVille = new Ville[10];

        try {

            System.out.println("tabVille[0] = Capitale(\"Paris\",558889,\"France\")");
            tabVille[0] = new Capitale("Paris", "France", 558889);

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[1] = Capitale(\"Londres\",\"Angleterre\")");
            tabVille[1] = new Capitale("Londres", "Angleterre");

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[2] = Ville(\"Nice\",354000)");
            tabVille[2] = new Ville("Nice", 354000);

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[3] = Capitale(\"Cagnes-sur-Mer\",154000)");
            tabVille[3] = new Capitale("Cagnes-sur-Mer", 154000);

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[4] = Patelin(\"Séranon\",400)");
            tabVille[4] = new Patelin("Séranon", 400);

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[5] = Patelin(\"Ovignon\")");
            tabVille[5] = new Patelin("Ovignon");

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[6] = Ville()");
            tabVille[6] = new Ville();

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[7] = Patelin()");
            tabVille[7] = new Patelin();

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[8] = Capitale()");
            tabVille[8] = new Capitale();

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        try {

            System.out.println("tabVille[9] = Capitale(\"Grasse\")");
            tabVille[9] = new Capitale("Grasse");

        } catch (TownException e){

            System.err.println(e.getMessage());

        }

        System.out.println("* --------------------------------------------------------- *");

        System.out.println("voici les villes :");

        for (Ville ville : tabVille){

            if (ville == null){

                continue;

            }

            System.out.println("- " + ville.description());

        }
    }
}

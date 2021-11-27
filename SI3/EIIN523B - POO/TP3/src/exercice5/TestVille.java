package exercice5;

public class TestVille {

    public static void main(String[] args){

        System.out.println("* -----------------------------------------------------------  *\n" +
                "* TP java - SI3                                                *\n" +
                "* @author robin viollet - robin viollet@etu.univ-cotedazur.fr  *\n" +
                "* @version TD3   - ex4                                         *\n" +
                "* -----------------------------------------------------------  *");

        System.out.println("voici les villes :");

        Capitale paris = new Capitale("Paris", "France", 558889);
        Capitale londres = new Capitale("Londres", "Angleterre");
        Ville nice = new Ville("Nice", 354000);
        Ville cagnessurmer = new Ville("Nice", 154000);
        Patelin seranon = new Patelin("Séranon", 400);
        Patelin ovignon = new Patelin("Ovignon");

        System.out.println("- " + paris.description() + ". La catégorie est : " + paris.categorie());
        System.out.println("- " + londres.description() + ". La catégorie est : " + londres.categorie());
        System.out.println("- " + nice.description() + ". La catégorie est : " + nice.categorie());
        System.out.println("- " + cagnessurmer.description() + ". La catégorie est : " + cagnessurmer.categorie());
        System.out.println("- " + seranon.description() + ". La catégorie est : " + seranon.categorie());
        System.out.println("- " + ovignon.description() + ". La catégorie est : " + ovignon.categorie());

    }
}

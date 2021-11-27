package exercice2;

public class Patelin extends Ville {

    public Patelin(String name){

        this(name, 0);

    }

    public Patelin(String name, int population){

        super(name, population);

        if (population > 1000){

            System.err.println("Erreur, le nb d'habitants est trop gros pour un Patelin ! L'application doit quitter !!!");
            System.exit(1);

        }
    }

    @Override
    public String description(){

        return name + " est un " + this.getClass().getSimpleName() + (population > 0 ? " de " + population + " habitants" : "");

    }
}

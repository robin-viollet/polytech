package exercice2;

public class Ville {

    public Ville(){

        System.err.println("Erreur, le nom est obligatoire ! L'application doit quitter !!!");
        System.exit(1);

        this.name = "";

    }

    public Ville(String name){

        this(name, 0);

    }

    public Ville(String name, int population){

        this.name = name;
        this.population = population;

    }

    protected final String name;
    protected int population;

    public String description(){

        String description = name + " est une " + this.getClass().getSimpleName() + (population > 0 ? " de " + population + " habitants" : "");

        if (this instanceof Capitale){

            description += ". C'est la capitale du pays " + ((Capitale) this).getCountry();

        } else if (this instanceof Patelin){

            return name + " est un " + this.getClass().getSimpleName() + (population > 0 ? " de " + population + " habitants" : "");

        }

        return description;

    }

    public String getNom(){

        return name;

    }

    public int getPopulation(){

        return population;

    }

    public void setPopulation(int population){

        this.population = population;

    }
}

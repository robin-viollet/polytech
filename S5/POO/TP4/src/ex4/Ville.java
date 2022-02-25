package ex4;

public class Ville {

    public Ville() throws TownException {

        throw new TownException("TownException error: le nom est obligatoire pour créer une Ville");

    }

    public Ville(String name) throws TownException {

        this(name, 0);

    }

    public Ville(String name, int population) throws TownException {

        this.name = name;
        this.population = population;

        if (this.getClass() == Ville.class && (population < 5001 || population > 100000)){

            throw new TownException("TownException error: le nombre d'habitant ne permet pas de créer la Ville " + name);

        }
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

    public char categorie(){

/*      • A : Celles qui ont entre un et 500 000 habitants.
        • B : Celles qui ont plus de 500 000 habitants.
        • ? : Celles dont le nombre d'habitant est nul ou inconnu;
        • C : Celles qui sont capitales quel que soit le nombre d'habitants;*/

        if (population > 0 && population <= 500000){

            return 'A';

        } else if (population > 500000){

            return 'B';

        } else {

            return '?';

        }
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

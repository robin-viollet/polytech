package ex4;

public class Capitale extends Ville {

    public Capitale() throws TownException {

        throw new TownException("TownException error: le nom est obligatoire pour créer une Capitale\n");

    }

    public Capitale(String name) throws TownException {

        this(name, 0);

    }

    public Capitale(String name, String country) throws TownException {

        this(name, country, 0);

    }

    public Capitale(String name, int population) throws TownException {

        throw new TownException("TownException error: la Capitale " + name + " doit représenter un pays");

    }

    public Capitale(String name, String country, int population) throws TownException {

        super(name, population);

        if (population < 100001){

            throw new TownException("TownException error: le nombre d'habitant ne permet pas de créer la Capitale " + name);

        }

        this.country = country;

    }

    private final String country;

    @Override
    public char categorie(){

        return 'C';

    }

    public String getCountry(){

        return country;

    }
}

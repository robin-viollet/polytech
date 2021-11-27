package exercice5;

public class Capitale extends Ville {

    public Capitale(String name, String country){

        this(name, country, 0);

    }

    public Capitale(String name, String country, int population){

        super(name, population);

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

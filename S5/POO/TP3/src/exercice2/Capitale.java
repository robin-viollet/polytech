package exercice2;

public class Capitale extends Ville {

    public Capitale(String name, String country){

        this(name, country, 0);

    }

    public Capitale(String name, String country, int population){

        super(name, population);

        this.country = country;

    }

    private final String country;

    public String getCountry(){

        return country;

    }
}

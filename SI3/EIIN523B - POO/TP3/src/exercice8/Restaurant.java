package exercice8;

public class Restaurant {

    public Restaurant(String name, int year){

        this.name = name;
        this.year = year;

    }

    private final String name;
    private final int year;

    public String getName(){

        return name;

    }

    public int getYear(){

        return year;

    }

    @Override
    public String toString(){

        return "\"" + name + "\" (" + year + ")";

    }
}

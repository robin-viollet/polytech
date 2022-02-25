package exercice8;

import java.util.Collection;

public class Menu {

    public Menu(String name, Restaurant creator, Collection<Restaurant> distributors){

        this.name = name;
        this.creator = creator;
        this.distributors = distributors;

    }

    private final String name;
    private final Restaurant creator;
    private final Collection<Restaurant> distributors;

    public String getName(){

        return name;

    }

    public Restaurant getCreator(){

        return creator;

    }

    public Collection<Restaurant> getDistributors(){

        return distributors;

    }

    @Override
    public String toString(){

        return "Menu \"" + name + "\", created by " + creator + " is deal by " + distributors;

    }
}
package ex4;

public class Patelin extends Ville {

    public Patelin() throws TownException {

        throw new TownException("TownException error: le nom est obligatoire pour créer un Patelin\n");

    }

    public Patelin(String name) throws TownException {

        this(name, 0);

    }

    public Patelin(String name, int population) throws TownException {

        super(name, population);

        if (population < 500 || population > 5000){

            throw new TownException("TownException error: le nombre d'habitant ne permet pas de créer le Patelin " + name);

        }
    }
}

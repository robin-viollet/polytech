package ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TweeterUser implements IObservable {

    public TweeterUser(String name, String pseudo){

        this.name = name;
        this.pseudo = pseudo;
        this.followers = new ArrayList<>();

    }

    private final String name;
    private final String pseudo;
    private List<IObserver> followers;

    public void tweet(String message){

        System.out.println(name + " has sent message: \"" + message + "\"");

        notifyObservers(message);

    }

    public String getName(){

        return name;
    }

    public String getPseudo(){

        return pseudo;
    }

    @Override
    public void addObserver(IObserver observer){

        followers.add(observer);

    }

    @Override
    public void delObserver(IObserver observer){

        followers.remove(observer);

    }

    @Override
    public void notifyObservers(String message){

        followers.forEach(observer -> observer.update(this, message));

    }
}

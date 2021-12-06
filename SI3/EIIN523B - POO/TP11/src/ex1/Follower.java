package ex1;

import java.util.ArrayList;
import java.util.List;

public class Follower implements IObserver {

    public Follower(String name){

        this.name = name;
        this.wantsToUnfollow = new ArrayList<>();

    }

    private final String name;
    private final List<TweeterUser> wantsToUnfollow;

    @Override
    public void update(TweeterUser followed, String message){

        System.out.println("==> DRING! " + name + " is notified that @" + followed.getPseudo() + " sent the tweet: \"" + message + "\"");

    }

    public void unfollow(TweeterUser user){

        user.delObserver(this);

        System.out.println("it's too much for " + name + " who unsubscribes from " + user.getPseudo());

    }

    public void addWantsToUnfollow(TweeterUser tweeterUser){

        wantsToUnfollow.add(tweeterUser);

    }

    public void react(){

        for (TweeterUser tweeterUser : wantsToUnfollow){

            unfollow(tweeterUser);

        }
    }
}

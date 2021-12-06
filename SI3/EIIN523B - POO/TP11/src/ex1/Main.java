package ex1;

import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Follower> createList(String... names){

        return Arrays.stream(names).map(Follower::new).toList();

    }

    public static void main(String[] args){

        TweeterUser sleepyJoe = new TweeterUser("Joe Biden", "sleepyJoe");
        TweeterUser orangeAnus = new TweeterUser("Donald Duck", "orangeAnus");

        Follower fred = new Follower("fred");
        Follower igor = new Follower("igor");
        Follower dino = new Follower("dino"){
            @Override
            public void update(TweeterUser followed, String message){

                super.update(followed, message);

                if (followed == orangeAnus){

                    addWantsToUnfollow(orangeAnus);

                }
            }
        };
        Follower pascal = new Follower("pascal");

        sleepyJoe.addObserver(fred);
        sleepyJoe.addObserver(dino);

        orangeAnus.addObserver(fred);
        orangeAnus.addObserver(igor);
        orangeAnus.addObserver(dino);
        orangeAnus.addObserver(pascal);

        sleepyJoe.tweet("Donald asked a foreign government to invent lies");
        orangeAnus.tweet("Joe should give up");
        dino.react();
        orangeAnus.tweet("Yesterday evening, I was in the lead (...) VERY STRANGE");

    }
}

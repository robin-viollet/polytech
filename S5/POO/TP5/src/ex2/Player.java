package ex2;

public class Player {

    public Player(String name){

        this.name = name;

    }

    private final String name;
    private Pokemon currentCard;

    public Pokemon getCard(){

        return currentCard;

    }

    public void setCard(Pokemon card){

        this.currentCard = card;

    }

    @Override
    public String toString(){

        return name;

    }
}

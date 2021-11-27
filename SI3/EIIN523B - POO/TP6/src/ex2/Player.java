package ex2;

import java.util.Stack;

public class Player {

    public Player(String name) throws DeckException {

        this.name = name;
        this.cards = new Stack<>();

    }

    private final String name;
    private final Stack<Card> cards;

    public boolean hasCards(){

        return !cards.isEmpty();

    }

    public Card popCard(){

        return cards.pop();

    }

    public void pushCard(Card card){

        cards.push(card);

    }

    public void showHand(){

        System.out.print(name + " --> [");

        int size = cards.size();

        if (size > 0){

            System.out.print(cards.get(0));

            for (int i = 1; i < size; ++i){

                System.out.print("," + cards.get(i));

            }
        }

        System.out.println("]");

    }

    public String getName(){

        return name;

    }

    @Override
    public String toString(){

        return name;

    }
}

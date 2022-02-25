package ex2;

import java.util.*;

public class Deck extends Stack<Card> {
    public static int DECK52 = 54;
    public static int DECK32 = 32;

    Deck() throws DeckException {

        this(1, DECK32);

    }

    Deck(int nbDeck) throws DeckException {

        this(nbDeck, DECK32);

    }

    Deck(int nbDeck, int nbCards) throws DeckException {

        if (nbCards != DECK32 && nbCards != DECK52){

            throw new DeckException("type of card set not available");

        }

        List<Card.Value> values = Arrays.stream(Card.Value.values()).filter(value -> switch (value){
            case AS, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING -> true;
            case TWO, THREE, FOUR, FIVE, SIX -> nbCards == DECK52;
            case JOCKER -> false;
        }).toList();

        for (int i = 0; i < nbDeck; i++){
            for (Card.Color color : Card.Color.values()){
                for (Card.Value value : values){

                    this.push(new Card(color, value));

                }
            }
        }

        if (nbCards == DECK52){

            this.push(new Card(Card.Color.SPADES, Card.Value.JOCKER));
            this.push(new Card(Card.Color.DIAMOND, Card.Value.JOCKER));

        }

        Collections.shuffle(this, new Random(0));

    }
}

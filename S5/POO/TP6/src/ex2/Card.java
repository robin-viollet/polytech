package ex2;

import java.util.Objects;

public class Card implements Comparable<Card> {

    enum Color {
        SPADES('♠'),
        CLOVER('♣'),
        DIAMOND('♦'),
        HEART('♥');

        Color(char color){

            this.color = color;

        }

        private final char color;

        @Override
        public String toString(){

            return String.valueOf(color);

        }
    }

    enum Value {
        TWO(2, "2"),
        THREE(3, "3"),
        FOUR(4, "4"),
        FIVE(5, "5"),
        SIX(6, "6"),
        SEVEN(7, "7"),
        EIGHT(8, "8"),
        NINE(9, "9"),
        TEN(10, "10"),
        JACK(11, "V"),
        QUEEN(12, "D"),
        KING(13, "R"),
        AS(14, "AS"),
        JOCKER(0,"JOCKER");

        Value(int value, String name){

            this.value = value;
            this.name = name;

        }

        final int value;
        final String name;

        @Override
        public String toString(){

            return name;

        }
    }

    public Card(Color color, Value value){

        this.color = color;
        this.value = value;

    }

    private final Value value;
    private final Color color;

    @Override
    public int compareTo(Card card){

        return value.value - card.value.value;

    }

    @Override
    public boolean equals(Object o){

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value;

    }

    @Override
    public int hashCode(){

        return Objects.hash(value);
    }

    @Override
    public String toString(){

        return value.toString() + (value != Value.JOCKER ? color.toString() : "");

    }
}

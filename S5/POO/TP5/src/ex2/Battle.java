package ex2;

public class Battle {
    public Battle(Referee.Packet packet){

        this.packet = packet;

    }

    public Referee.Packet packet;

    public int play(Player player1, Player player2){

        Pokemon card1 = player1.getCard();
        Pokemon card2 = player2.getCard();

        card1.setLife(card1.getLife() - card2.getAttack() + card1.getDefense());
        card2.setLife(card2.getLife() - card1.getAttack() + card2.getDefense());

        return Integer.compare(card1.getLife(), card2.getLife());

    }
}

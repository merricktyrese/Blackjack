import java.util.*;

public class Hand {
    public ArrayList<Card> hand;

    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public static Hand newHand() {
        return new Hand(new Arraylist<Card>());
    }

    public void addCard (Card c) {
        hand.add(c);
    }

    public int getHandValue() {
        int value = 0;
        for (Card c : hand) {
            value += c.getRank();
        }
    }
}
import java.util.*;

public class Hand {
    public ArrayList<Card> hand;

    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public Hand() {
    }

    public static Hand newHand() {
        return new Hand(new ArrayList<Card>());
    }

    public void addCard (Card c) {
        hand.add(c);
    }

    public int getHandValue() {
        int value = 0;
        for (Card c : hand) {
            value += c.cardValue();
        }
        return value;
    }

    public void bust() {
        hand.clear();
    }

    public Card viewFirst() {
        return hand.get(0);
    }
}
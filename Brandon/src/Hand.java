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
        int aces = 0;
        for (Card c : hand) {
            value += c.cardValue();
            if (c.cardValue() == 11){
                aces++;
            }
        }
        if (value > 21 && aces > 0){
            value-= 10 * aces;
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
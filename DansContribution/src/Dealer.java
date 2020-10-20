import java.util.ArrayList;

public class Dealer extends Person {
    public Person player;
    public Hand hand;
    public Deck deck;

    public Dealer (Hand hand, Deck, deck) {
        this.hand = hand;
        this.deck = deck;
    }

    public static Dealer startGame(Hand hand, Deck deck) {
        Dealer d = new Dealer(hand, deck);
        return d;
    }

    public Card hit() {
        Card c = deck.removeNext();
        return c;
    }

    public void newDeck() {
        if(deck.isEmpty()) {
            deck = Deck.createDeck();
        }
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public void deal() {
        for (int i = 0; i < 2; i++) {
            hit();
            player.hit;
        }
    }

    public Card displayPlayerView() {
        return hand.viewFirst();
    }

    public Hand viewHand() {
        return hand;
    }

    @Override public String toString() {
        return hand.toString();
    }

    public static void main(String[] args) {
        Deck d = Deck.createDeck();

        Hand h = new Hand(new ArrayList<Card>());
        Hand h1 = new Hand(new ArrayList<Card>());

        Dealer dealer = Dealer.startGame(h, d);
        Player player = Player.joinGame(h1, 500);

        dealer.setPlayer(player);
        player.setDealer(dealer);
        dealer.deal();

        player.hit();
        player.hit();
    }
}

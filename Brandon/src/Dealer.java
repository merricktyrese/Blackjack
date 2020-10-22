import java.util.ArrayList;

public class Dealer extends Player {
    public Player player;
    private Hand hand;
    public Deck deck;
    public String name;

    public Dealer (Deck deck) {
        this.hand = Hand.newHand();
        this.deck = deck;
        this.name = "Dealer";
    }

    public static Dealer startGame(Deck deck) {
        return new Dealer(deck);
    }

    public void hit() {
        Card c = Deck.getNext();
        hand.addCard(c);
    }

    public void newDeck() {
        if(deck.isEmpty()) {
//            deck = Deck.createDeck();
            deck.wash();
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void deal() {
        for (int i = 0; i < 2; i++) {
            hit();
            player.hit();
        }
    }

    public Card displayPlayerView() {
        return hand.viewFirst();
    }

//    public Hand viewHand() {
//        return hand;
//    }

    @Override public String toString() {
        return hand.toString();
    }

//    public static void main(String[] args) {
//        Deck d = Deck.createDeck();
//
//        Hand h = new Hand(new ArrayList<Card>());
//        Hand h1 = new Hand(new ArrayList<Card>());
//
//        Dealer dealer = Dealer.startGame(h, d);
//        Player player = Player.joinGame(h1, 500);
//
//        dealer.setPlayer(player);
//        player.setDealer(dealer);
//        dealer.deal();
//
//        player.hit();
//        player.hit();
//    }
}

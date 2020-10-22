public class Player {

    public String name;
    public Hand hand;
    public int chips;

    public Player(String name){
        this.name = name;
        this.hand = Hand.newHand();
        this.chips = 1000;
    }

    public Player() {
    }

    public Hand getHand() {
        return hand;
    }

    public void hit(){
        Card c = Deck.getNext();
        hand.addCard(c);
        Deck.removeCard();
    }

    //public void Hit{
        //code to add another card to hand
    //}

    // public ArrayList ViewHand(){}

    @Override public String toString() {
        return hand.toString();
    }
}
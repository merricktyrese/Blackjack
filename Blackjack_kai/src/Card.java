public class Card {
    private Suit s;
    private Rank r;

    public Card(Suit s, Rank r) {
        this.s = s;
        this.r = r;
    }

    @Override
    public String toString() {
        return s+" "+r.getValue();
    }

    public Suit getSuit() {
        return s;
    }

    public Rank getRank() {
        return r;
    }
}

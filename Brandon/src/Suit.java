public enum Suit {
    HEARTS("Heart"),
    SPADES("Spades"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");


    final private String name;
    private Suit (String d) {
        name=d;
    }

    public String toString() {
        return name;
    }
}

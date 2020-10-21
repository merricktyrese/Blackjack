import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cardDeck = new ArrayList<>(208);

    public Deck() {
       cardDeck = createDeck();
       wash();
    }



    private ArrayList<Card> createDeck(){
         ArrayList<Card> cards = new ArrayList<>(208);
        for(int i=0;i<4;i++){
            for(Suit s:Suit.values()){
                for(Rank r:Rank.values()) {
                    cards.add(new Card(s, r));
                }
            }
        }

        return cards;
    }

    public void wash(){
        Collections.shuffle(cardDeck);
    }

//    public static void main(String[] args) {
//        Deck d=new Deck();
//
//        System.out.println(d.cardDeck.get(0).toString());
//    }
}

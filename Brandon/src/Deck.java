import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static List<Card> cardDeck = new ArrayList<>(208);

    public Deck() {
       cardDeck = createDeck();
       wash();
    }



    public static ArrayList<Card> createDeck(){
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

    public static Card getNext() {
        return cardDeck.get(0);
    }

    public static void removeCard(){
        cardDeck.remove(0);
    }

    public void wash(){
        Collections.shuffle(cardDeck);
    }

    public boolean isEmpty() {
        if (cardDeck.isEmpty()){
            return true;
        } else{
            return false;
        }
    }

//    public static void main(String[] args) {
//        Deck d=new Deck();
//
//        System.out.println(d.cardDeck.get(0).toString());
//    }
}

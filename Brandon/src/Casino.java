import java.util.Scanner;

public class Casino {
    public static void main(String[] args){
        boolean leave = true;
        String choice = "";
        int bet = 0;

        System.out.println("Welcome to Blackjack");
        System.out.print("Enter player name: ");
        Scanner scan = new Scanner(System.in);
        Player player = new Player(scan.nextLine());

        System.out.println();
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        System.out.println("Welcome "+player.name +"! Your starting pot is $"+player.chips);
        System.out.println("Let's play...");
        System.out.println();
        while (leave) {
            System.out.println("Enter bet amount: $");
            bet = scan.nextInt();

            while (bet < 1 || bet > player.chips) {
                System.out.print("not enough chips, bet again");
                bet = scan.nextInt();
            }
            dealer.setPlayer(player);
            dealer.deal();
            System.out.println("your cards: ");
            System.out.println(player.hand.viewFirst());// needs to show both cards but there no function for it
            // System.out.println(player.hand.hand); hand always give duplicates
             System.out.println("your total is " +player.hand.getHandValue());
            System.out.println();
            System.out.print("Hit or Stay: ");
            Scanner hit = new Scanner(System.in);
            choice = hit.nextLine();
            if(choice.equals("hit")) {
                player.hit();
                System.out.println(player.hand.hand);
                if (player.hand.getHandValue() > 21) {
                    System.out.println("you bust with " + player.hand.getHandValue());
                    break;
                }
            }
            else{
               //System.out.println("your cards are the same");
            }
            dealer.hit();
            dealer.hit();
            System.out.println("the dealer cards are: "+ dealer.getHand());// needs to get dealer cards



            }





        }


    }


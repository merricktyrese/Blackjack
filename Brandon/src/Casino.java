import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
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
        System.out.println("Welcome " + player.name + "! Your starting pot is $" + player.chips);
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
            if (player.hand.getHandValue() == 21) {
                System.out.println("your total is " + player.hand.getHandValue());
                break;
            } else {
                System.out.println("your total is " + player.hand.getHandValue());
            }
            System.out.println();
            System.out.print("Hit or Stay: ");
            Scanner hit = new Scanner(System.in);
            choice = hit.nextLine();
            while (choice.equals("hit")) {
                player.hit();
                System.out.println(player.hand.hand);
                if (player.hand.getHandValue() > 21) {
                    System.out.println("you bust with " + player.hand.getHandValue());
                    break;
                } else if (player.hand.getHandValue() == 21) {
                    System.out.println("your total is " + player.hand.getHandValue());
                } else {
                    System.out.println("Your total is " + player.hand.getHandValue());
                    System.out.println();
                    System.out.print("Hit or Stay: ");
                    choice = hit.nextLine();
                }
            }
            if (choice.equals("stay")) {
                dealer.hit();
                dealer.hit();
                System.out.println("the dealers cards are: " + dealer.getHand().hand);
                if (dealer.getHand().getHandValue() == 21) {

                    if (player.hand.getHandValue() == 21) {
                        System.out.println("--Push--");
                    } else {
                        player.chips = player.chips - bet;
                        System.out.println("The dealer has blackjack!");
                        System.out.println("Your pot is now $" + player.chips);
                    }
                }
                else if(dealer.getHand().getHandValue() > player.hand.getHandValue() && dealer.getHand().getHandValue() < 22){
                    System.out.println(dealer.getHand().getHandValue()+" Dealer Wins!");
                    player.chips = player.chips - bet;
                    System.out.println("Your pot is now $"+player.chips);
                }
                else if(dealer.getHand().getHandValue() == player.hand.getHandValue() && player.hand.getHandValue() >= 17){
                    System.out.println("push");
                }
                else{
                    do {
                        System.out.println("the dealers total is: " + dealer.getHand().getHandValue());
                        dealer.hit();
                        System.out.println("the dealers cards: " + dealer.getHand().hand);
                        if (dealer.getHand().getHandValue() == 21) {
                            if (player.hand.getHandValue() == 21) {
                                System.out.println("push");
                            } else {
                                player.chips = player.chips - bet;
                                System.out.println("The dealer has blackjack!");
                                System.out.println("Your pot is now $" + player.chips);
                                break;
                            }
                        } else if (dealer.getHand().getHandValue() > player.hand.getHandValue() && dealer.getHand().getHandValue() < 22) {
                            System.out.println(dealer.getHand().getHandValue()+ " Dealer Wins!");
                            player.chips = player.chips - bet;
                            System.out.println("Your pot is now $" + player.chips);
                            break;
                        } else if (dealer.getHand().getHandValue() == player.hand.getHandValue() && player.hand.getHandValue() >= 17) {
                            System.out.println("Push");
                            break;
                        }
                    }while (dealer.getHand().getHandValue() < 22 );
                    if (dealer.getHand().getHandValue() > 21) {
                        System.out.println("you got blackjack");
                        player.chips = player.chips + bet;
                        System.out.println("Your pot is now " + player.chips);
                    }
                    else {
                        System.out.println();
                        System.out.println(dealer.getHand().getHandValue()+" Dealer busts. You WIN!");
                        player.chips = player.chips + bet;
                        System.out.println("Your pot is now " + player.chips);
                    }
                    }

                }

            }
        if (player.chips == 0){
            leave = true;
        }
        else{
            System.out.print("Play another hand? (y/n) ");
            Scanner end = new Scanner(System.in);
            String answer = end.nextLine();
            if(answer.equals("n")){
                leave = true;
            }
        }

        }
    }
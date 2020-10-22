import java.util.Scanner;

public class Casino {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to Blackjack");
        System.out.print("Enter player name: ");
        Scanner scan = new Scanner(System.in);
        Player player = new Player(scan.nextLine());

        System.out.println();
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        System.out.println("Welcome " + player.name + "! Your starting chip count is $" + player.chips);
        System.out.println("Let's play...");
        System.out.println();
        Casino.play(dealer, player);
        Casino.playAgain(dealer, player);
    }

    static void play(Dealer dealer, Player player) throws InterruptedException {
        System.out.println("Your chip count is $" + player.chips);
        System.out.print("Enter bet amount: $");
        Scanner scan = new Scanner(System.in);
        int bet = scan.nextInt();

        while (bet < 1 || bet > player.chips) {
            System.out.print("not a valid bet, choose a valid chip amount");
            bet = scan.nextInt();
        }
        dealer.setPlayer(player);
        dealer.deal();
        System.out.println("your cards: ");
        System.out.println(player.hand.hand);
        System.out.println("your total is " + player.hand.getHandValue());
        System.out.println();
        System.out.println("the dealer is showing a: " + dealer.hand.viewFirst());
        System.out.println();
        System.out.print("Hit or Stay: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        while (choice.equals("hit")) {
            player.hit();
            Thread.sleep(1000);
            System.out.println(player.hand.hand);
            if (player.hand.getHandValue() > 21) {
                System.out.println("you bust with " + player.hand.getHandValue());
                break;
            }
            System.out.println("Your hand value is: " + player.hand.getHandValue() + " what would you like to do next?(hit/stay)");
            choice = input.nextLine();
        }

        System.out.println("The dealer has: " + dealer.hand.hand);
        Thread.sleep(3000);

        if (dealer.hand.getHandValue() == 21){
            System.out.println("Dealer got blackjack. Sucks to suck.");
        }
        while (dealer.hand.getHandValue() <= 21) {
            if (dealer.hand.getHandValue() > 21) {
                System.out.println("The dealer bust with " + dealer.hand.getHandValue());
                System.out.println("The dealer has: " + dealer.hand.hand);
                Thread.sleep(3000);
            }

            if (dealer.hand.getHandValue() < 17) {
                dealer.hit();
                System.out.println("The dealer has: " + dealer.hand.hand);
                Thread.sleep(3000);
            } else {
                System.out.println("The dealer stays with " + dealer.hand.getHandValue());
                Thread.sleep(3000);
                break;
            }
        }

        if (dealer.hand.getHandValue() < player.hand.getHandValue() && player.hand.getHandValue() < 22 || dealer.hand.getHandValue() > 21 && player.hand.getHandValue() < 22) {
            System.out.println("Congrats. you beat the dealer and have received $" + bet + " in chips");
            player.chips += bet;
        } else if (dealer.hand.getHandValue() > player.hand.getHandValue() && dealer.hand.getHandValue() < 22 || player.hand.getHandValue() > 21 && dealer.hand.getHandValue() < 22) {
            System.out.println("That's too bad, the dealer beat you and you have lost $" + bet + " in chips");
            player.chips -= bet;
        } else if (dealer.hand.getHandValue() == player.hand.getHandValue() || dealer.hand.getHandValue() > 21 && player.hand.getHandValue() > 21) {
            System.out.println("Your hand and the dealers hand was equal and you have pushed, you will get your money back.. this time.");
        }
    }

    static void playAgain(Dealer dealer, Player player) throws InterruptedException {
        System.out.println("Do you want to play another hand?(y/n)");
        Scanner getInput = new Scanner(System.in);
        String playagain = getInput.nextLine();
        while (playagain.equals("y")) {
            dealer.hand.hand.clear();
            player.hand.hand.clear();
            play(dealer, player);
            System.out.println("Do you want to play another hand?(y/n)");
            playagain = getInput.nextLine();
        }
        System.out.println("OK, you have left the table with $" + player.chips);
    }
}


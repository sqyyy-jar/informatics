package y23.m03.d02;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Scanner;

@Page("02.03.2023")
public class BlackJack {
    private final Scanner scanner;
    private final Card[] playerCards = new Card[21];
    private final Card[] croupiersCards = new Card[21];
    private int playerCardCount = 0;
    private int croupiersCardCount = 0;
    private int playerPoints = 0;
    private int croupiersPoints = 0;
    private int playerAces = 0;
    private int croupiersAces = 0;

    private BlackJack(Scanner scanner) {
        this.scanner = scanner;
    }

    @Entrypoint
    public static void main() {
        final Scanner scanner = new Scanner(System.in);
        new BlackJack(scanner).run();
        while (true) {
            System.out.print("Do you want keep playing? [y/N] ");
            final String s = scanner.nextLine().trim();
            if (s.equalsIgnoreCase("n") || s.isBlank()) {
                break;
            }
            if (!s.equalsIgnoreCase("y")) {
                continue;
            }
            new BlackJack(scanner).run();
        }
    }

    private void addPlayerCard(Card card) {
        playerCards[playerCardCount++] = card;
        playerPoints += card.getNum();
        if (card == Card.Ace) {
            playerAces += 1;
            playerPoints -= 10;
        }
        System.out.printf("You: %s\n", card.getName());
    }

    private void addCroupiersCard(Card card) {
        croupiersCards[croupiersCardCount++] = card;
        croupiersPoints += card.getNum();
        if (card == Card.Ace) {
            croupiersAces += 1;
            croupiersPoints -= 10;
        }
        System.out.printf("Croupiers: %s\n", card.getName());
    }

    private Card randCard() {
        return Card.values()[(int) (Math.random() * Card.values().length)];
    }

    public void run() {
        addPlayerCard(randCard());
        addCroupiersCard(randCard());
        addPlayerCard(randCard());
        while (true) {
            System.out.print("Do you want a new card? [Y/n] ");
            final String s = scanner.nextLine().trim();
            if (s.equalsIgnoreCase("n")) {
                break;
            }
            if (!s.isBlank() && !s.equalsIgnoreCase("y")) {
                continue;
            }
            addPlayerCard(randCard());
            if (playerPoints > 21) {
                System.out.println("You lost! You have too many points.");
                System.out.printf("You got %d points.\n", playerPoints);
                System.out.printf("The croupier got %d points.\n\n", croupiersPoints);
                return;
            }
            if (playerPoints == 21) {
                break;
            }
            // if (playerCardCount == 2) {
            //     if (playerCards[0] != Card.Ace && playerCards[1] != Card.Ace) {
            //         continue;
            //     }
            //     if (playerCards[0].getNum() != 10 && playerCards[1].getNum() != 10) {
            //         continue;
            //     }
            //     break;
            // }
        }
        for (int i = 0; i < playerAces; i++) {
            if (playerPoints + 10 > 21) {
                break;
            }
            playerPoints += 10;
        }
        addCroupiersCard(randCard());
        if (croupiersPoints <= 16) {
            addCroupiersCard(randCard());
        }
        if (croupiersPoints > 21) {
            System.out.println("You won! The croupier has too many points.");
        }
        if (playerPoints == croupiersPoints) {
            System.out.println("It's a draw! Both have an equal amount of points.");
        }
        if (playerPoints > croupiersPoints) {
            System.out.println("You won! You have more points than the croupier.");
        } else {
            System.out.println("You lost! You have less points than the croupier.");
        }
        System.out.printf("You got %d points.\n", playerPoints);
        System.out.printf("The croupier got %d points.\n\n", croupiersPoints);
    }
}

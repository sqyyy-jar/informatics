package y23.m03.d02;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Scanner;

@Page("02.03.2023")
public class BlackJack {
    private final Scanner scanner;
    private int playerPoints = 0;
    private int croupiersPoints = 0;

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
        playerPoints += card.getNum();
        if (card == Card.Ace && playerPoints > 21) {
            playerPoints -= 10;
        }
        System.out.printf("You: %s (%d total points)\n", card.getName(), playerPoints);
    }

    private void addCroupiersCard(Card card) {
        croupiersPoints += card.getNum();
        if (card == Card.Ace && croupiersPoints > 21) {
            croupiersPoints -= 10;
        }
        System.out.printf("Croupiers: %s (%d total points)\n", card.getName(), croupiersPoints);
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
            if (playerPoints == 21) {
                break;
            }
            if (playerPoints <= 21) {
                continue;
            }
            System.out.println("You lost! You have too many points.");
            System.out.printf("You got %d points.\n", playerPoints);
            System.out.printf("The croupier got %d points.\n\n", croupiersPoints);
            return;
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

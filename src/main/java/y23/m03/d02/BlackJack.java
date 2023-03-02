package y23.m03.d02;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Scanner;

@Page("02.03.2023")
public class BlackJack {
    private static final String[] CARDS = {"Ass", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "König"};
    private static final int[] POINTS = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private final Scanner scanner;
    private final int[] playerCards = new int[21];
    private final int[] croupiersCards = new int[21];
    private int playerCardCount = 0;
    private int croupiersCardCount = 0;
    private int playerPoints = 0;
    private int croupiersPoints = 0;
    private int playerAsses = 0;
    private int croupiersAsses = 0;

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

    private void addPlayerCard(int card) {
        playerCards[playerCardCount++] = card;
        playerPoints += POINTS[card];
        if (card == 0) {
            playerAsses += 1;
            playerPoints -= 10;
        }
        System.out.printf("You: %s\n", CARDS[card]);
    }

    private void addCroupiersCard(int card) {
        croupiersCards[croupiersCardCount++] = card;
        croupiersPoints += POINTS[card];
        if (card == 0) {
            croupiersAsses += 1;
            croupiersPoints -= 10;
        }
        System.out.printf("Croupiers: %s\n", CARDS[card]);
    }

    private int randCard() {
        return (int) (Math.random() * CARDS.length);
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
        }
        for (int i = 0; i < playerAsses; i++) {
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
            System.out.println("It's a draw! Both have equal amount of points.");
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

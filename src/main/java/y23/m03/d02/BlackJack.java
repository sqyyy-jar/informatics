package y23.m03.d02;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Scanner;

@Page("02.03.2023")
public class BlackJack {
    private static final String[] cards = {"Ass", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "König"};
    private static final int[] points = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private final Scanner scanner;
    private final int[] playerCards = new int[11];
    private int playerCardCount = 0;
    private int playerPoints = 0;
    private int asses = 0;

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

    private void addCard(int card) {
        playerCards[playerCardCount++] = card;
        playerPoints += points[card];
        if (card == 0) {
            asses += 1;
            playerPoints -= 10;
        }
        System.out.println(cards[card]);
    }

    private int randCard() {
        return (int) (Math.random() * cards.length);
    }

    public void run() {
        addCard(randCard());
        addCard(randCard());
        while (true) {
            System.out.print("Do you want a new card? [Y/n] ");
            final String s = scanner.nextLine().trim();
            if (s.equalsIgnoreCase("n")) {
                break;
            }
            if (!s.isBlank() && !s.equalsIgnoreCase("y")) {
                continue;
            }
            addCard(randCard());
            if (playerPoints > 21) {
                System.out.println("You lost!");
                return;
            }
        }
        for (int i = 0; i < asses; i++) {
            if (playerPoints + 10 > 21) {
                break;
            }
            playerPoints += 10;
        }
        System.out.printf("You got %d points.\n", playerPoints);
    }
}

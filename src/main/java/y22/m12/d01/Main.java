package y22.m12.d01;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;
import informatics.Exercise;

import java.util.Scanner;

@Page("01.12.2022")
@Exercise("_")
public class Main {
    public static void run() {
        main(null);
    }

    @Entrypoint
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        outer:
        while (true) {
            System.out.println("""
                Was würdest du gerne erstellen?
                 1) PKW
                 2) LKW""");
            System.out.print("=> ");
            final int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> System.out.println("PKW-Erstellung:");
                case 2 -> System.out.println("LKW-Erstellung:");
                default -> {
                    continue;
                }
            }
            System.out.print("Farbe: ");
            final String farbe = scanner.nextLine();
            System.out.print("Kennzeichen: ");
            final String kennzeichen = scanner.nextLine();
            System.out.print("Kilometerstand: ");
            final double kilometerstand = scanner.nextDouble();
            switch (option) {
                case 1 -> {
                    System.out.print("Laderaum: ");
                    final double kofferraumGroesse = scanner.nextDouble();
                    final Pkw pkw = new Pkw(farbe, kennzeichen, kilometerstand, kofferraumGroesse);
                    System.out.println(pkw);
                    break outer;
                }
                case 2 -> {
                    System.out.print("Laderaum: ");
                    final double laderaum = scanner.nextDouble();
                    System.out.print("Nutzlast: ");
                    final double nutzlast = scanner.nextDouble();
                    System.out.print("Kilometerpreis: ");
                    final double kmPreis = scanner.nextDouble();
                    System.out.print("Freie Kilometer pro Tag: ");
                    final double freieKmProTag = scanner.nextDouble();
                    final Lkw lkw = new Lkw(farbe, kennzeichen, kilometerstand, laderaum, nutzlast, kmPreis, freieKmProTag);
                    System.out.println(lkw);
                    break outer;
                }
            }
        }
    }
}

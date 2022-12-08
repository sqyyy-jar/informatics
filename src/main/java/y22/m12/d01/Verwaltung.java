package y22.m12.d01;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;
import informatics.Exercise;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Page("01.12.2022")
@Exercise("_")
public class Verwaltung {
    public static void run() {
        main(null);
    }

    @Entrypoint
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Kunde> kunden = new ArrayList<>();
        final List<Pkw> pkws = new ArrayList<>();
        final List<Lkw> lkws = new ArrayList<>();
        outer:
        while (true) {
            System.out.println("""
                Was würdest du gerne tun?
                 0) Programm beenden
                 1) Kunde registrieren
                 2) PKW registrieren
                 3) LKW registrieren""");
            System.out.print(">>> ");
            final String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "0", "exit" -> {
                    break outer;
                }
                case "1", "kunde" -> kunden.add(readKunde(scanner));
                case "2", "pkw" -> pkws.add(readPkw(scanner));
                case "3", "lkw" -> lkws.add(readLkw(scanner));
                default -> {
                    continue;
                }
            }
            System.out.println();
        }
        System.out.println("Kunden:");
        for (final Kunde kunde : kunden) {
            System.out.println(kunde);
        }
        System.out.println("PKWs:");
        for (final Pkw pkw : pkws) {
            System.out.println(pkw);
        }
        System.out.println("LKWs:");
        for (final Lkw lkw : lkws) {
            System.out.println(lkw);
        }
    }

    private static Kunde readKunde(Scanner scanner) {
        System.out.println("Kunden-Registrierung:");
        System.out.print("Vorname: ");
        final String vorname = scanner.nextLine();
        System.out.print("Nachname: ");
        final String name = scanner.nextLine();
        System.out.print("Geburtsdatum (jjjj-mm-tt): ");
        final Date geburtsdatum = Date.valueOf(scanner.nextLine());
        return new Kunde(name, vorname, geburtsdatum);
    }

    private static Pkw readPkw(Scanner scanner) {
        System.out.println("PKW-Registrierung:");
        System.out.print("Farbe: ");
        final String farbe = scanner.nextLine();
        System.out.print("Kennzeichen: ");
        final String kennzeichen = scanner.nextLine();
        System.out.print("Kilometerstand: ");
        final double kilometerstand = scanner.nextDouble();
        System.out.print("Laderaum: ");
        final double kofferraumGroesse = scanner.nextDouble();
        return new Pkw(farbe, kennzeichen, kilometerstand, kofferraumGroesse);
    }

    private static Lkw readLkw(Scanner scanner) {
        System.out.println("LKW-Registrierung:");
        System.out.print("Farbe: ");
        final String farbe = scanner.nextLine();
        System.out.print("Kennzeichen: ");
        final String kennzeichen = scanner.nextLine();
        System.out.print("Kilometerstand: ");
        final double kilometerstand = scanner.nextDouble();
        System.out.print("Laderaum: ");
        final double laderaum = scanner.nextDouble();
        System.out.print("Nutzlast: ");
        final double nutzlast = scanner.nextDouble();
        System.out.print("Kilometerpreis: ");
        final double kmPreis = scanner.nextDouble();
        System.out.print("Freie Kilometer pro Tag: ");
        final double freieKmProTag = scanner.nextDouble();
        return new Lkw(farbe, kennzeichen, kilometerstand, laderaum, nutzlast, kmPreis, freieKmProTag);
    }
}

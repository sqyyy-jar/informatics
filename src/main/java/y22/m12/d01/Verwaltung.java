package y22.m12.d01;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.sql.Date;
import java.util.Scanner;

@Page("01.12.2022")
public class Verwaltung {
    @Entrypoint
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // Memory
        final int kundeMemSize = 3;
        int kundeMem = 0;
        Kunde kunde0 = null;
        Kunde kunde1 = null;
        Kunde kunde2 = null;
        final int pkwMemSize = 3;
        int pkwMem = 0;
        Pkw pkw0 = null;
        Pkw pkw1 = null;
        Pkw pkw2 = null;
        final int lkwMemSize = 3;
        int lkwMem = 0;
        Lkw lkw0 = null;
        Lkw lkw1 = null;
        Lkw lkw2 = null;
        // Memory
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
                case "1", "kunde" -> {
                    if (kundeMem >= kundeMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        continue;
                    }
                    final Kunde kunde = readKunde(scanner);
                    switch (kundeMem) {
                        case 0 -> kunde0 = kunde;
                        case 1 -> kunde1 = kunde;
                        case 2 -> kunde2 = kunde;
                    }
                    kundeMem++;
                }
                case "2", "pkw" -> {
                    if (pkwMem >= pkwMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        continue;
                    }
                    final Pkw pkw = readPkw(scanner);
                    switch (pkwMem) {
                        case 0 -> pkw0 = pkw;
                        case 1 -> pkw1 = pkw;
                        case 2 -> pkw2 = pkw;
                    }
                    pkwMem++;
                }
                case "3", "lkw" -> {
                    if (lkwMem >= lkwMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        continue;
                    }
                    final Lkw lkw = readLkw(scanner);
                    switch (lkwMem) {
                        case 0 -> lkw0 = lkw;
                        case 1 -> lkw1 = lkw;
                        case 2 -> lkw2 = lkw;
                    }
                    lkwMem++;
                }
                default -> {
                    continue;
                }
            }
            System.out.println();
        }
        System.out.println("Kunden:");
        for (int i = 0; i < Math.min(kundeMemSize, kundeMem); i++) {
            System.out.println(switch (i) {
                case 0 -> kunde0;
                case 1 -> kunde1;
                case 2 -> kunde2;
                default -> null;
            });
        }
        System.out.println("PKWs:");
        for (int i = 0; i < Math.min(pkwMemSize, pkwMem); i++) {
            System.out.println(switch (i) {
                case 0 -> pkw0;
                case 1 -> pkw1;
                case 2 -> pkw2;
                default -> null;
            });
        }
        System.out.println("LKWs:");
        for (int i = 0; i < Math.min(lkwMemSize, lkwMem); i++) {
            System.out.println(switch (i) {
                case 0 -> lkw0;
                case 1 -> lkw1;
                case 2 -> lkw2;
                default -> null;
            });
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
        scanner.nextLine();
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
        scanner.nextLine();
        return new Lkw(farbe, kennzeichen, kilometerstand, laderaum, nutzlast, kmPreis, freieKmProTag);
    }
}

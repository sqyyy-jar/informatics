package y22.m12.d01;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.sql.Date;
import java.util.Scanner;

@Page("01.12.2022")
public class Verwaltung {
    private static final int kundeMemSize = 3;
    private static final int pkwMemSize = 3;
    private static final int lkwMemSize = 3;
    private static int kundeMem = 0;
    private static Kunde kunde0 = null;
    private static Kunde kunde1 = null;
    private static Kunde kunde2 = null;
    private static int pkwMem = 0;
    private static Pkw pkw0 = null;
    private static Pkw pkw1 = null;
    private static Pkw pkw2 = null;
    private static int lkwMem = 0;
    private static Lkw lkw0 = null;
    private static Lkw lkw1 = null;
    private static Lkw lkw2 = null;

    @Entrypoint
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            running = readChoice(scanner);
        }
    }

    private static boolean readChoice(Scanner scanner) {
        outer:
        while (true) {
            System.out.println("""
                Was würdest du gerne tun?
                 0) Programm beenden
                 1) Etwas ausgeben
                 2) Etwas registrieren
                 3) Etwas modifizieren""");
            prompt();
            final String choice = scanner.nextLine().toLowerCase();
            System.out.println();
            switch (choice) {
                case "0", "exit" -> {
                    return false;
                }
                case "1", "ausgeben" -> {
                    readAusgeben(scanner);
                    break outer;
                }
                case "2", "registrieren" -> {
                    readRegistrieren(scanner);
                    break outer;
                }
                case "3", "modifizieren" -> {
                    readModifizieren(scanner);
                    break outer;
                }
                default -> System.out.println();
            }
        }
        return true;
    }

    private static void readAusgeben(Scanner scanner) {
        System.out.println("""
            Was würdest du gerne ausgeben?
             1) Kunde
             2) PKW
             3) LKW""");
        prompt();
        final String choice = scanner.nextLine().toLowerCase();
        System.out.println();
        switch (choice) {
            case "1", "kunde" -> {
                System.out.println("Welchen Kunden würdest du gerne ausgeben? (1..3)");
                prompt();
                final int kundeI = chooseKunde(scanner);
                if (kundeI == -1) {
                    break;
                }
                final Kunde kunde = getKunde(kundeI);
                System.out.println(kunde);
            }
            case "2", "pkw" -> {
                System.out.println("Welchen PKW würdest du gerne ausgeben? (1..3)");
                prompt();
                final int pkwI = choosePkw(scanner);
                if (pkwI == -1) {
                    break;
                }
                final Pkw pkw = getPkw(pkwI);
                System.out.println(pkw);
            }
            case "3", "lkw" -> {
                System.out.println("Welchen PKW würdest du gerne ausgeben? (1..3)");
                prompt();
                final int lkwI = chooseLkw(scanner);
                if (lkwI == -1) {
                    break;
                }
                final Lkw lkw = getLkw(lkwI);
                System.out.println(lkw);
            }
            default -> System.out.println();
        }
    }

    private static void readRegistrieren(Scanner scanner) {
        outer:
        while (true) {
            System.out.println("""
                Was würdest du gerne registrieren?
                 1) Kunde
                 2) PKW
                 3) LKW""");
            prompt();
            final String choice = scanner.nextLine().toLowerCase();
            System.out.println();
            switch (choice) {
                case "1", "kunde" -> {
                    if (kundeMem >= kundeMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        break outer;
                    }
                    final Kunde kunde = readKunde(scanner);
                    setKunde(kundeMem, kunde);
                    kundeMem++;
                    break outer;
                }
                case "2", "pkw" -> {
                    if (pkwMem >= pkwMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        break outer;
                    }
                    final Pkw pkw = readPkw(scanner);
                    setPkw(pkwMem, pkw);
                    pkwMem++;
                    break outer;
                }
                case "3", "lkw" -> {
                    if (lkwMem >= lkwMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        break outer;
                    }
                    final Lkw lkw = readLkw(scanner);
                    setLkw(lkwMem, lkw);
                    lkwMem++;
                    break outer;
                }
                default -> System.out.println();
            }
        }
        System.out.println();
    }

    private static void readModifizieren(Scanner scanner) {
        System.out.println("""
            Was würdest du gerne modifizieren?
             1) Kunde
             2) PKW
             3) LKW""");
        prompt();
        final String choice = scanner.nextLine().toLowerCase();
        System.out.println();
        switch (choice) {
            case "1", "kunde", "3", "lkw" -> System.out.println("Unimplemented");
            case "2", "pkw" -> {
                System.out.println("""
                    Was würdest du gerne tun?
                     1) Tanken""");
                prompt();
                final String option = scanner.nextLine().toLowerCase();
                System.out.println();
                switch (option) {
                    case "1", "tanken" -> {
                        System.out.println("Welchen PKW würdest du gerne tanken? (1..3)");
                        prompt();
                        final int pkwI = choosePkw(scanner);
                        System.out.println();
                        if (pkwI == -1) {
                            break;
                        }
                        final Pkw pkw = getPkw(pkwI);
                        System.out.println("Wie viel würdest du gerne tanken?");
                        prompt();
                        final double tank = scanner.nextDouble();
                        final double oldTank = pkw.getTank();
                        pkw.setTank(Math.min(pkw.getTank() + tank, pkw.getMaxTank()));
                        System.out.println("Es wurden " + (pkw.getTank() - oldTank) + "l getankt.\n");
                    }
                }
            }
            default -> System.out.println();
        }
    }

    private static void prompt() {
        System.out.print(">>> ");
    }

    private static int chooseKunde(Scanner scanner) {
        final int kunde = scanner.nextInt();
        scanner.nextLine();
        if (kunde < 1 || kunde > kundeMemSize) {
            System.out.println("Dieser Kunde ist noch nicht registriert.");
            return -1;
        }
        return kunde - 1;
    }

    private static int choosePkw(Scanner scanner) {
        final int pkw = scanner.nextInt();
        scanner.nextLine();
        if (pkw < 1 || pkw > pkwMemSize) {
            System.out.println("Dieser PKW ist noch nicht registriert.");
            return -1;
        }
        return pkw - 1;
    }

    private static int chooseLkw(Scanner scanner) {
        final int lkw = scanner.nextInt();
        scanner.nextLine();
        if (lkw < 1 || lkw > lkwMemSize) {
            System.out.println("Dieser LKW ist noch nicht registriert.");
            return -1;
        }
        return lkw - 1;
    }

    private static Kunde getKunde(int index) {
        return switch (index) {
            case 0 -> kunde0;
            case 1 -> kunde1;
            case 2 -> kunde2;
            default -> null;
        };
    }

    private static Pkw getPkw(int index) {
        return switch (index) {
            case 0 -> pkw0;
            case 1 -> pkw1;
            case 2 -> pkw2;
            default -> null;
        };
    }

    private static Lkw getLkw(int index) {
        return switch (index) {
            case 0 -> lkw0;
            case 1 -> lkw1;
            case 2 -> lkw2;
            default -> null;
        };
    }

    private static void setKunde(int index, Kunde kunde) {
        switch (index) {
            case 0 -> kunde0 = kunde;
            case 1 -> kunde1 = kunde;
            case 2 -> kunde2 = kunde;
        }
    }

    private static void setPkw(int index, Pkw pkw) {
        switch (index) {
            case 0 -> pkw0 = pkw;
            case 1 -> pkw1 = pkw;
            case 2 -> pkw2 = pkw;
        }
    }

    private static void setLkw(int index, Lkw lkw) {
        switch (index) {
            case 0 -> lkw0 = lkw;
            case 1 -> lkw1 = lkw;
            case 2 -> lkw2 = lkw;
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
        System.out.print("Kilometerstand (km): ");
        final double kilometerstand = scanner.nextDouble();
        System.out.print("Tank (l): ");
        final double tank = scanner.nextDouble();
        System.out.print("max. Tank (l): ");
        final double maxTank = scanner.nextDouble();
        System.out.print("Laderaum (l): ");
        final double kofferraumGroesse = scanner.nextDouble();
        scanner.nextLine();
        return new Pkw(farbe, kennzeichen, kilometerstand, tank, maxTank, kofferraumGroesse);
    }

    private static Lkw readLkw(Scanner scanner) {
        System.out.println("LKW-Registrierung:");
        System.out.print("Farbe: ");
        final String farbe = scanner.nextLine();
        System.out.print("Kennzeichen: ");
        final String kennzeichen = scanner.nextLine();
        System.out.print("Kilometerstand: ");
        final double kilometerstand = scanner.nextDouble();
        System.out.print("Tank (l): ");
        final double tank = scanner.nextDouble();
        System.out.print("max. Tank (l): ");
        final double maxTank = scanner.nextDouble();
        System.out.print("Laderaum: ");
        final double laderaum = scanner.nextDouble();
        System.out.print("Nutzlast: ");
        final double nutzlast = scanner.nextDouble();
        System.out.print("Kilometerpreis: ");
        final double kmPreis = scanner.nextDouble();
        System.out.print("Freie Kilometer pro Tag: ");
        final double freieKmProTag = scanner.nextDouble();
        scanner.nextLine();
        return new Lkw(farbe, kennzeichen, kilometerstand, tank, maxTank, laderaum, nutzlast, kmPreis, freieKmProTag);
    }
}

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
            System.out.print(">>> ");
            switch (scanner.nextLine().toLowerCase()) {
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
        outer:
        while (true) {
            System.out.println("""
                Was würdest du gerne ausgeben?
                 1) Kunde
                 2) PKW
                 3) LKW""");
            System.out.print(">>> ");
            switch (scanner.nextLine().toLowerCase()) {
                case "1", "kunde" -> {
                    System.out.println("Welchen Kunden würdest du gerne ausgeben? (1..3)");
                    final int kunde = scanner.nextInt();
                    switch (kunde) {
                        case 1 -> {
                            if (kundeMem >= 1) {
                                System.out.println(kunde0);
                            } else {
                                break;
                            }
                            break outer;
                        }
                        case 2 -> {
                            if (kundeMem >= 2) {
                                System.out.println(kunde1);
                            } else {
                                break;
                            }
                            break outer;
                        }
                        case 3 -> {
                            if (kundeMem >= 3) {
                                System.out.println(kunde2);
                            } else {
                                break;
                            }
                            break outer;
                        }
                    }
                    System.out.println("Dieser Kunde ist noch nicht registriert.");
                }
                case "2", "pkw" -> {
                    System.out.println("Welchen PKW würdest du gerne ausgeben? (1..3)");
                    final int pkw = scanner.nextInt();
                    switch (pkw) {
                        case 1 -> {
                            if (pkwMem >= 1) {
                                System.out.println(pkw0);
                            } else {
                                break;
                            }
                            break outer;
                        }
                        case 2 -> {
                            if (pkwMem >= 2) {
                                System.out.println(pkw1);
                            } else {
                                break;
                            }
                            break outer;
                        }
                        case 3 -> {
                            if (pkwMem >= 3) {
                                System.out.println(pkw2);
                            } else {
                                break;
                            }
                            break outer;
                        }
                    }
                    System.out.println("Dieser PKW ist noch nicht registriert.");
                }
                case "3", "lkw" -> {
                    System.out.println("Welchen PKW würdest du gerne ausgeben? (1..3)");
                    final int lkw = scanner.nextInt();
                    switch (lkw) {
                        case 1 -> {
                            if (lkwMem >= 1) {
                                System.out.println(lkw0);
                            } else {
                                break;
                            }
                            break outer;
                        }
                        case 2 -> {
                            if (lkwMem >= 2) {
                                System.out.println(lkw1);
                            } else {
                                break;
                            }
                            break outer;
                        }
                        case 3 -> {
                            if (lkwMem >= 3) {
                                System.out.println(lkw2);
                            } else {
                                break;
                            }
                            break outer;
                        }
                    }
                    System.out.println("Dieser LKW ist noch nicht registriert.");
                }
                default -> System.out.println();
            }
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
            System.out.print(">>> ");
            switch (scanner.nextLine().toLowerCase()) {
                case "1", "kunde" -> {
                    if (kundeMem >= kundeMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        break outer;
                    }
                    final Kunde kunde = readKunde(scanner);
                    switch (kundeMem) {
                        case 0 -> kunde0 = kunde;
                        case 1 -> kunde1 = kunde;
                        case 2 -> kunde2 = kunde;
                    }
                    kundeMem++;
                    break outer;
                }
                case "2", "pkw" -> {
                    if (pkwMem >= pkwMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        break outer;
                    }
                    final Pkw pkw = readPkw(scanner);
                    switch (pkwMem) {
                        case 0 -> pkw0 = pkw;
                        case 1 -> pkw1 = pkw;
                        case 2 -> pkw2 = pkw;
                    }
                    pkwMem++;
                    break outer;
                }
                case "3", "lkw" -> {
                    if (lkwMem >= lkwMemSize) {
                        System.out.println("Es konnte nicht genug Speicher gefunden werden.\n");
                        break outer;
                    }
                    final Lkw lkw = readLkw(scanner);
                    switch (lkwMem) {
                        case 0 -> lkw0 = lkw;
                        case 1 -> lkw1 = lkw;
                        case 2 -> lkw2 = lkw;
                    }
                    lkwMem++;
                    break outer;
                }
                default -> System.out.println();
            }
        }
    }

    private static void readModifizieren(Scanner scanner) {
        System.out.println("Unimplementiert");
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

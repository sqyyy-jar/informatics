package y23.m02.d16;

// Deklariert eine neue Klasse namens Mitarbeiter
public class Mitarbeiter {
    // Deklariert ein Attribut namens name vom Typ String
    private String name;
    // Deklariert ein Attribut gehalt vom Typ double
    private double gehalt;

    // Deklariert einen Konstruktor, welcher einen String name und einen double gehalt entgegennimmt
    public Mitarbeiter(String name, double gehalt) {
        // Setzt das Attribut name auf den Wert des Parameters name
        this.name = name;
        // Setzt das Attribut gehalt auf den Wert des Parameters gehalt
        this.gehalt = gehalt;
    }

    // Deklariert eine Methode namens ausgeben, welche keine Parameter hat und nichts zurückgibt
    public void ausgeben() {
        // Gibt den Namen und das Gehalt des Mitarbeiters aus
        System.out.println(name + " " + gehalt);
    }

    // Deklariert einen Getter namens getGehalt, welcher einen double zurückgibt
    public double getGehalt() {
        // Gibt den Attributwert von gehalt zurück-
        return gehalt;
    }
}

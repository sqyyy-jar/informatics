package y22.m12.d05.carrent;

public class Verwaltung {
    public static void main(String[] args) {
        Pkw auto1 = new Pkw("blau", "BMW E46 M3", 5);
        Pkw auto2 = new Pkw("rot", "Opel Corsa", 3);
        Pkw auto3 = new Pkw("grau", "VW Golf", 5);
        Kunde kunde1 = new Kunde(0, "Doe", "John");
        Kunde kunde2 = new Kunde(1, "Mustermann", "Max");
    }
}

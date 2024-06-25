package y24.m06.d25;

public class Person {
    private String nachname;
    private String vorname;
    private String email;

    public Person(String nachname, String vorname) {
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean istKleiner(Person vergleichsPerson) {
        return false;
    }

    public boolean istGleich(Person vergleichsPerson) {
        return false;
    }
}

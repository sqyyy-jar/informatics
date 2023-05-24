package y23.m05.d24;

public class Person {
    private String nachname;
    private String vorname;
    private String mail;

    public Person(String nachname, String vorname, String mail) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.mail = mail;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public boolean istKleiner(Person vergleichPerson) {
        int i = nachname.compareTo(vergleichPerson.nachname);
        if (i == 0) {
            return vorname.compareTo(vergleichPerson.vorname) < 0;
        }
        return i < 0;
    }

    @Override
    public String toString() {
        return "Person{" + "nachname='" + nachname + '\'' + ", vorname='" + vorname + '\'' + '}';
    }
}

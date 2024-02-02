package y23.m05.d24;

import java.util.Date;

public class Person {
    private String nachname;
    private String vorname;
    private String mail;
    private Date geburtsdatum;

    public Person(String nachname, String vorname, String mail, Date geburtsdatum) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.mail = mail;
        this.geburtsdatum = geburtsdatum;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getMail() {
        return mail;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public boolean istKleiner(Person vergleichPerson) {
        int i = nachname.compareTo(vergleichPerson.nachname);
        if (i == 0) {
            i = vorname.compareTo(vergleichPerson.vorname);
        }
        if (i == 0) {
            i = geburtsdatum.compareTo(vergleichPerson.geburtsdatum);
        }
        return i < 0;
    }

    @Override
    public String toString() {
        return "Person{" +
            "nachname='" + nachname + '\'' +
            ", vorname='" + vorname + '\'' +
            ", mail='" + mail + '\'' +
            ", geburtsdatum=" + geburtsdatum +
            '}';
    }
}

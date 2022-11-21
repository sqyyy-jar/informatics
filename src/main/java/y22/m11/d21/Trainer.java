package y22.m11.d21;

import java.util.Date;

public class Trainer extends Person {
    private boolean lizenz;
    private int fortbildungen;

    public Trainer(String name, String vorname, Date geburtsdatum, boolean lizenz, int fortbildungen) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.lizenz = lizenz;
        this.fortbildungen = fortbildungen;
    }

    public boolean hasLizenz() {
        return lizenz;
    }

    public int getFortbildungen() {
        return fortbildungen;
    }
}

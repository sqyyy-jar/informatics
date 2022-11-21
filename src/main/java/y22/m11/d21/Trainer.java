package y22.m11.d21;

import java.util.Date;

public class Trainer extends Person {
    private boolean lizenz;
    private int fortbildungen;

    public Trainer(String name, String vorname, Date geburtsdatum, boolean lizenz, int fortbildungen) {
        super(name, vorname, geburtsdatum);
        /* this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum; */
        this.lizenz = lizenz;
        this.fortbildungen = fortbildungen;
    }

    public boolean hasLizenz() {
        return lizenz;
    }

    public void setLizenz(boolean lizenz) {
        this.lizenz = lizenz;
    }

    public int getFortbildungen() {
        return fortbildungen;
    }

    public void setFortbildungen(int fortbildungen) {
        this.fortbildungen = fortbildungen;
    }
}

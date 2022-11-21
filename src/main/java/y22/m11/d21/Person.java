package y22.m11.d21;

import java.util.Date;

public abstract class Person {
    protected String name;
    protected String vorname;
    protected Date geburtsdatum;

    public Person(String name, String vorname, Date geburtsdatum) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
}

package y22.m11.d21;

import java.util.Date;

public abstract class Person {
    protected String name;
    protected String vorname;
    protected Date geburtsdatum;

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }
}

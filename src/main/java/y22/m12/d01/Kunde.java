package y22.m12.d01;

import java.util.Date;

public class Kunde {
    private String name;
    private String vorname;
    private Date geburtsDatum;

    public Kunde(String name, String vorname, Date geburtsDatum) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsDatum = geburtsDatum;
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

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public String toString() {
        return """
            Kunde {
              Name: %s,
              Vorname: %s,
              Geburtsdatum: %s
            }
            """.formatted(name, vorname, geburtsDatum);
    }
}

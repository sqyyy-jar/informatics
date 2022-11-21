package y22.m11.d21;

import java.util.Date;

public class Spieler extends Person {
    private String stammposition;
    private String alternativposition;
    private int fitnesslevel;

    public Spieler(String name, String vorname, Date geburtsdatum, String stammposition, String alternativposition,
                   int fitnesslevel) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.stammposition = stammposition;
        this.alternativposition = alternativposition;
        this.fitnesslevel = fitnesslevel;
    }

    public String getStammposition() {
        return stammposition;
    }

    public void setStammposition(String stammposition) {
        this.stammposition = stammposition;
    }

    public String getAlternativposition() {
        return alternativposition;
    }

    public void setAlternativposition(String alternativposition) {
        this.alternativposition = alternativposition;
    }

    public int getFitnesslevel() {
        return fitnesslevel;
    }

    public void setFitnesslevel(int fitnesslevel) {
        this.fitnesslevel = fitnesslevel;
    }
}

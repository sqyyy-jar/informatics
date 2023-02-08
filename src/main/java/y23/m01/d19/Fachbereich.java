package y23.m01.d19;

import java.util.Arrays;

public class Fachbereich {
    private int nummer;
    private String name;
    private int index;
    private Vorlesung[] vorlesungen;

    public Fachbereich(int nummer, String name) {
        this.nummer = nummer;
        this.name = name;
        this.index = 0;
        this.vorlesungen = new Vorlesung[100];
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vorlesung getVorlesung(int index) {
        return vorlesungen[index];
    }

    public void setVorlesung(int index, Vorlesung vorlesung) {
        this.vorlesungen[index] = vorlesung;
    }

    public void fuegeVerlesungHinzu(Vorlesung vorlesung) {
        vorlesungen[index++] = vorlesung;
    }

    @Override
    public String toString() {
        return "Fachbereich{" + "nummer=" + nummer + ", name='" + name + "', vorlesungen=" + Arrays.toString(vorlesungen) + '}';
    }
}

package y23.m05.d08;

public class Teilnehmer {
    private String name;
    private String vorname;
    private boolean essenBezahlt;

    public Teilnehmer(String name, String vorname, boolean essenBezahlt) {
        this.name = name;
        this.vorname = vorname;
        this.essenBezahlt = essenBezahlt;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public boolean hatEssenBezahlt() {
        return essenBezahlt;
    }
}

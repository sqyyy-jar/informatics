package y23.m05.d08;

public class Teilnehmer {
    private String name;
    private String vorname;
    private String klasse;

    public Teilnehmer(String name, String vorname, String klasse) {
        this.name = name;
        this.vorname = vorname;
        this.klasse = klasse;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getKlasse() {
        return klasse;
    }
}

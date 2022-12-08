package y22.m12.d05.carrent;

public class Kunde {
    private int kundenNummer;
    private String name;
    private String vorname;

    public Kunde(int kundenNummer, String name, String vorname) {
        this.kundenNummer = kundenNummer;
        this.name = name;
        this.vorname = vorname;
    }

    public int getKundenNummer() {
        return kundenNummer;
    }

    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
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
}

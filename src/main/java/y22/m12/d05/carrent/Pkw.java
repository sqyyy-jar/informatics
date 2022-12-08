package y22.m12.d05.carrent;

public class Pkw {
    private String farbe;
    private String bezeichnung;
    private int anzahlTüren;
    private boolean anhängerKupplung;
    private double kmStand;

    public Pkw(String farbe, String bezeichnung, int anzahlTüren) {
        this.farbe = farbe;
        this.bezeichnung = bezeichnung;
        this.anzahlTüren = anzahlTüren;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getAnzahlTüren() {
        return anzahlTüren;
    }

    public void setAnzahlTüren(int anzahlTüren) {
        this.anzahlTüren = anzahlTüren;
    }

    public boolean isAnhängerKupplung() {
        return anhängerKupplung;
    }

    public void setAnhängerKupplung(boolean anhängerKupplung) {
        this.anhängerKupplung = anhängerKupplung;
    }

    public double getKmStand() {
        return kmStand;
    }

    public void setKmStand(double kmStand) {
        this.kmStand = kmStand;
    }
}

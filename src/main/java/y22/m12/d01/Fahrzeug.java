package y22.m12.d01;

public abstract class Fahrzeug {
    protected String farbe;
    protected String kennzeichen;
    protected double kilometerstand;

    public Fahrzeug(String farbe, String kennzeichen, double kilometerstand) {
        this.farbe = farbe;
        this.kennzeichen = kennzeichen;
        this.kilometerstand = kilometerstand;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public double getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(double kilometerstand) {
        this.kilometerstand = kilometerstand;
    }
}

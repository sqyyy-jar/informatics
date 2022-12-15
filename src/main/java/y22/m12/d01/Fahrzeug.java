package y22.m12.d01;

public abstract class Fahrzeug {
    protected String farbe;
    protected String kennzeichen;
    protected double kilometerstand;
    protected double tank;
    protected double maxTank;

    public Fahrzeug(String farbe, String kennzeichen, double kilometerstand, double tank, double maxTank) {
        this.farbe = farbe;
        this.kennzeichen = kennzeichen;
        this.kilometerstand = kilometerstand;
        this.tank = tank;
        this.maxTank = maxTank;
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

    public double getTank() {
        return tank;
    }

    public void setTank(double tank) {
        this.tank = tank;
    }

    public double getMaxTank() {
        return maxTank;
    }

    public void setMaxTank(double maxTank) {
        this.maxTank = maxTank;
    }
}

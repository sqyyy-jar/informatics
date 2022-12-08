package y22.m12.d01;

public class Lkw extends Fahrzeug {
    private double laderaum;
    private double nutzlast;
    private double kmPreis;
    private double freieKmProTag;

    public Lkw(String farbe, String kennzeichen, double kilometerstand, double laderaum, double nutzlast, double kmPreis,
               double freieKmProTag) {
        super(farbe, kennzeichen, kilometerstand);
        this.laderaum = laderaum;
        this.nutzlast = nutzlast;
        this.kmPreis = kmPreis;
        this.freieKmProTag = freieKmProTag;
    }

    public double getLaderaum() {
        return laderaum;
    }

    public void setLaderaum(double laderaum) {
        this.laderaum = laderaum;
    }

    public double getNutzlast() {
        return nutzlast;
    }

    public void setNutzlast(double nutzlast) {
        this.nutzlast = nutzlast;
    }

    public double getKmPreis() {
        return kmPreis;
    }

    public void setKmPreis(double kmPreis) {
        this.kmPreis = kmPreis;
    }

    public double getFreieKmProTag() {
        return freieKmProTag;
    }

    public void setFreieKmProTag(int freieKmProTag) {
        this.freieKmProTag = freieKmProTag;
    }

    @Override
    public String toString() {
        return "Lkw{" + "laderaum=" + laderaum + ", nutzlast=" + nutzlast + ", kmPreis=" + kmPreis + ", freieKmProTag=" +
            freieKmProTag + ", farbe='" + farbe + '\'' + ", kennzeichen='" + kennzeichen + '\'' + ", kilometerstand=" +
            kilometerstand + '}';
    }
}

package y22.m12.d01;

public class Lkw extends Fahrzeug {
    private double laderaum;
    private double nutzlast;
    private double kmPreis;
    private double freieKmProTag;

    public Lkw(String farbe, String kennzeichen, double kilometerstand, double tank, double maxTank, double laderaum,
               double nutzlast, double kmPreis,
               double freieKmProTag) {
        super(farbe, kennzeichen, kilometerstand, tank, maxTank);
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
        return """
            LKW {
              Farbe: %s,
              Kennzeichen: %s,
              Kilometerstand: %.2fkm,
              Tank: %.2fl,
              max. Tank: %.2fl,
              Laderaum: %.2fl,
              Nutzlast: %.2fkg,
              Kilometer-Preis: %.2f€,
              Freie Kilometer pro Tag: %.2fkm
            }
            """.formatted(farbe, kennzeichen, kilometerstand, tank, maxTank, laderaum, nutzlast, kmPreis, freieKmProTag);
    }
}

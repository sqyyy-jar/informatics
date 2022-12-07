package y22.m12.d01;

public class Pkw extends Fahrzeug {
    private double kofferraumGroesse;

    public Pkw(String farbe, String kennzeichen, double kilometerstand, double kofferraumGroesse) {
        super(farbe, kennzeichen, kilometerstand);
        this.kofferraumGroesse = kofferraumGroesse;
    }

    public double getKofferraumGroesse() {
        return kofferraumGroesse;
    }

    public void setKofferraumGroesse(double kofferraumGroesse) {
        this.kofferraumGroesse = kofferraumGroesse;
    }

    @Override
    public String toString() {
        return "Pkw{" + "kofferraumGroesse=" + kofferraumGroesse + ", farbe='" + farbe + '\'' + ", kennzeichen='" + kennzeichen +
            '\'' + ", kilometerstand=" + kilometerstand + '}';
    }
}

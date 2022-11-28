package y22.m11.d24.carrent;

import java.util.Date;

public class Pkw extends Fahrzeug {
    private double kofferraumGroesse;

    public Pkw(String kennzeichen, String typ, double kmStand, String treibstoff, Date alter, boolean klimaanlage,
               boolean sitzheitzung, double verbrauch, String schadstoffBelastung, String versicherung,
               double grundtarif, boolean verfuegbarkeit, int tueren, double leistung, double kofferraumGroesse) {
        super(kennzeichen, typ, kmStand, treibstoff, alter, klimaanlage, sitzheitzung, verbrauch, schadstoffBelastung,
                versicherung, grundtarif, verfuegbarkeit, tueren, leistung);
        this.kofferraumGroesse = kofferraumGroesse;
    }

    public double getKofferraumGroesse() {
        return kofferraumGroesse;
    }

    public void setKofferraumGroesse(double kofferraumGroesse) {
        this.kofferraumGroesse = kofferraumGroesse;
    }
}

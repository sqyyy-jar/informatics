package y23.m09.d05;

public class Yen extends Waehrung {
    private static double kurs;
    private double wert;

    public Yen(double wert) {
        this.wert = wert;
    }

    @Override
    public double dollarBetrag() {
        return wert * kurs;
    }

    public static void setKurs(double kurs) {
        Yen.kurs = kurs;
    }
}

package y23.m09.d05;

public class Euro extends Waehrung {
    private static double kurs = 1;
    private double wert;

    public Euro(double wert) {
        this.wert = wert;
    }

    @Override
    public double dollarBetrag() {
        return wert * kurs;
    }

    public double euroBetrag() {
        return wert;
    }

    public static void setEuroKurs(double kurs) {
        Euro.kurs = kurs;
    }
}

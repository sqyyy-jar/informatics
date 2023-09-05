package y23.m09.d05;

public class USDollar extends Waehrung {
    private double wert;

    public USDollar(double wert) {
        this.wert = wert;
    }

    @Override
    public double dollarBetrag() {
        return wert;
    }
}

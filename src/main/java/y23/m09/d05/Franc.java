package y23.m09.d05;

public class Franc extends Euro {
    public Franc(double wert) {
        super(wert / 6.55957);
    }

    public Franc(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return euroBetrag() * 6.55957;
    }
}

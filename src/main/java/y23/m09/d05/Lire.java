package y23.m09.d05;

public class Lire extends Euro {
    public Lire(double wert) {
        super(wert / 1936.27);
    }

    public Lire(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return euroBetrag() * 1936.27;
    }
}

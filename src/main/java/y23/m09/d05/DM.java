package y23.m09.d05;

public class DM extends Euro {
    public DM(double wert) {
        super(wert / 1.95583);
    }

    public DM(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return euroBetrag() * 1.95583;
    }
}

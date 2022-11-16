package y22.m11.d14;

import java.util.Date;

public class Pauschalvertrag extends Vertrag {
    private double lohn;

    public Pauschalvertrag(Date vertragsdatum, double lohn) {
        super(vertragsdatum);
        this.lohn = lohn;
    }

    @Override
    public double kostenBerechnen() {
        return lohn;
    }

    // getters and setters
}
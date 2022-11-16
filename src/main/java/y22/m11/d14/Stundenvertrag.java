package y22.m11.d14;

import java.util.Date;

public class Stundenvertrag extends Vertrag {
    private double stundensatz;
    private int stundenzahl;

    public Stundenvertrag(Date vertragsdatum, double stundensatz, int stundenzahl) {
        this(vertragsdatum);
        this.stundensatz = stundensatz;
        this.stundenzahl = stundenzahl;
    }

    @Override
    public double kostenBerechnen() {
        return stundenzahl * stundensatz;
    }

    // getters and setters
}
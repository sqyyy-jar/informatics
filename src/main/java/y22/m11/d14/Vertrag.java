package y22.m11.d14;

import java.util.Date;

public abstract class Vertrag {
    private Date vertragsdatum;
    
    public Vertrag(Date vertragsdatum) {
        this.vertragsdatum = vertragsdatum;
    }

    public abstract double kostenBerechnen();
}
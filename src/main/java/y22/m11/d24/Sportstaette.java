package y22.m11.d24;

public abstract class Sportstaette {
    protected double grundgebuehr;

    public Sportstaette(double grundgebuehr) {
        this.grundgebuehr = grundgebuehr;
    }

    public double gibGrundgebuehr() {
        return grundgebuehr;
    }

    public abstract double gibGesamtgebuehr();
}

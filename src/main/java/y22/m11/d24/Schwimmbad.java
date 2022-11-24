package y22.m11.d24;

public class Schwimmbad extends Sportstaette {
    private double prozentAufschlag;

    public Schwimmbad(double grundgebuehr, double prozentAufschlag) {
        super(grundgebuehr);
        this.prozentAufschlag = prozentAufschlag;
    }

    public double getProzentAufschlag() {
        return prozentAufschlag;
    }

    public void setProzentAufschlag(double prozentAufschlag) {
        this.prozentAufschlag = prozentAufschlag;
    }

    @Override
    public double gibGesamtgebuehr() {
        return (1 + prozentAufschlag / 100) * gibGrundgebuehr();
    }
}

package y22.m11.d24;

public class Fussballplatz extends Sportstaette {
    private int anzahlTrainingseinheiten;
    private double gebuehrProTrainingseinheit;

    public Fussballplatz(double grundgebuehr, int anzahlTrainingseinheiten,
        double gebuehrProTrainingseinheit) {
        super(grundgebuehr);
        this.anzahlTrainingseinheiten = anzahlTrainingseinheiten;
        this.gebuehrProTrainingseinheit = gebuehrProTrainingseinheit;
    }

    public int getAnzahlTrainingseinheiten() {
        return anzahlTrainingseinheiten;
    }

    public void setAnzahlTrainingseinheiten(int anzahlTrainingseinheiten) {
        this.anzahlTrainingseinheiten = anzahlTrainingseinheiten;
    }

    public double getGebuehrProTrainingseinheit() {
        return gebuehrProTrainingseinheit;
    }

    public void setGebuehrProTrainingseinheit(double gebuehrProTrainingseinheit) {
        this.gebuehrProTrainingseinheit = gebuehrProTrainingseinheit;
    }

    @Override
    public double gibGesamtgebuehr() {
        return gibGrundgebuehr() + anzahlTrainingseinheiten * gebuehrProTrainingseinheit;
    }
}

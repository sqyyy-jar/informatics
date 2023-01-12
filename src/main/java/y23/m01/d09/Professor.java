package y23.m01.d09;

public class Professor extends Person {
    private double lohn;

    public Professor(String name, String telefonNummer, String email, Wohnadresse wohnadresse, double lohn) {
        super(name, telefonNummer, email, wohnadresse);
        this.lohn = lohn;
    }

    public double getLohn() {
        return lohn;
    }

    public void setLohn(double lohn) {
        this.lohn = lohn;
    }
}

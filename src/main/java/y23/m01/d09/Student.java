package y23.m01.d09;

public class Student extends Person {
    private int martikelNummer;
    private double durchschnittsNote;

    public Student(String name, String telefonNummer, String email, Wohnadresse wohnadresse, int martikelNummer, double durchschnittsNote) {
        super(name, telefonNummer, email, wohnadresse);
        this.martikelNummer = martikelNummer;
        this.durchschnittsNote = durchschnittsNote;
    }

    public void einschreiben(Modul modul) {
        // TODO
    }

    public int getMartikelNummer() {
        return martikelNummer;
    }

    public void setMartikelNummer(int martikelNummer) {
        this.martikelNummer = martikelNummer;
    }

    public double getDurchschnittsNote() {
        return durchschnittsNote;
    }

    public void setDurchschnittsNote(double durchschnittsNote) {
        this.durchschnittsNote = durchschnittsNote;
    }
}

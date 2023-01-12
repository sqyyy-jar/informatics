package y23.m01.d09;

public class Person {
    protected String name;
    protected String telefonNummer;
    protected String email;
    protected Wohnadresse wohnadresse;

    public Person(String name, String telefonNummer, String email, Wohnadresse wohnadresse) {
        this.name = name;
        this.telefonNummer = telefonNummer;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Wohnadresse getWohnadresse() {
        return wohnadresse;
    }

    public void setWohnadresse(Wohnadresse wohnadresse) {
        this.wohnadresse = wohnadresse;
    }
}

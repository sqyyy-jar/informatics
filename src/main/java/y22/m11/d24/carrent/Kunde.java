package y22.m11.d24.carrent;

public class Kunde {
    private int kundenNummer;
    private String vorname;
    private String nachname;
    private String email;
    private String addresse;
    private String telefon;

    public Kunde(int kundenNummer, String vorname, String nachname, String email, String addresse, String telefon) {
        this.kundenNummer = kundenNummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.addresse = addresse;
        this.telefon = telefon;
    }

    public int getKundenNummer() {
        return kundenNummer;
    }

    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

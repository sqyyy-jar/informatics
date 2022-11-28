package y22.m11.d24.carrent;

import java.util.Date;

public abstract class Fahrzeug {
    protected String kennzeichen;
    protected String typ;
    protected double kmStand;
    protected String treibstoff;
    protected Date alter;
    protected boolean klimaanlage;
    protected boolean sitzheitzung;
    protected double verbrauch;
    protected String schadstoffBelastung;
    protected String versicherung;
    protected double grundtarif;
    protected boolean verfuegbar;
    protected int tueren;
    protected double leistung;

    public Fahrzeug(String kennzeichen, String typ, double kmStand, String treibstoff, Date alter, boolean klimaanlage,
                    boolean sitzheitzung, double verbrauch, String schadstoffBelastung, String versicherung,
                    double grundtarif, boolean verfuegbarkeit, int tueren, double leistung) {
        this.kennzeichen = kennzeichen;
        this.typ = typ;
        this.kmStand = kmStand;
        this.treibstoff = treibstoff;
        this.alter = alter;
        this.klimaanlage = klimaanlage;
        this.sitzheitzung = sitzheitzung;
        this.verbrauch = verbrauch;
        this.schadstoffBelastung = schadstoffBelastung;
        this.versicherung = versicherung;
        this.grundtarif = grundtarif;
        this.verfuegbar = verfuegbarkeit;
        this.tueren = tueren;
        this.leistung = leistung;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getKmStand() {
        return kmStand;
    }

    public void setKmStand(double kmStand) {
        this.kmStand = kmStand;
    }

    public String getTreibstoff() {
        return treibstoff;
    }

    public void setTreibstoff(String treibstoff) {
        this.treibstoff = treibstoff;
    }

    public Date getAlter() {
        return alter;
    }

    public void setAlter(Date alter) {
        this.alter = alter;
    }

    public boolean hasKlimaanlage() {
        return klimaanlage;
    }

    public void setKlimaanlage(boolean klimaanlage) {
        this.klimaanlage = klimaanlage;
    }

    public boolean hasSitzheitzung() {
        return sitzheitzung;
    }

    public void setSitzheitzung(boolean sitzheitzung) {
        this.sitzheitzung = sitzheitzung;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }

    public String getSchadstoffBelastung() {
        return schadstoffBelastung;
    }

    public void setSchadstoffBelastung(String schadstoffBelastung) {
        this.schadstoffBelastung = schadstoffBelastung;
    }

    public String getVersicherung() {
        return versicherung;
    }

    public void setVersicherung(String versicherung) {
        this.versicherung = versicherung;
    }

    public double getGrundtarif() {
        return grundtarif;
    }

    public void setGrundtarif(double grundtarif) {
        this.grundtarif = grundtarif;
    }

    public boolean isVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    public int getTueren() {
        return tueren;
    }

    public void setTueren(int tueren) {
        this.tueren = tueren;
    }

    public double getLeistung() {
        return leistung;
    }

    public void setLeistung(double leistung) {
        this.leistung = leistung;
    }
}

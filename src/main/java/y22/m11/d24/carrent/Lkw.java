package y22.m11.d24.carrent;

import java.util.Date;

public class Lkw extends Fahrzeug {
    private double laderaum;
    private double nutzlast;
    private double kmPreis;
    private int freieKmProTag;
    private String fuehrerscheinAnforderung;

    public Lkw(String kennzeichen, String typ, double kmStand, String treibstoff, Date alter, boolean klimaanlage,
               boolean sitzheitzung, double verbrauch, String schadstoffBelastung, String versicherung,
               double grundtarif, boolean verfuegbarkeit, int tueren, double leistung, double laderaum, double nutzlast,
               double kmPreis, int freieKmProTag, String fuehrerscheinAnforderung) {
        super(kennzeichen, typ, kmStand, treibstoff, alter, klimaanlage, sitzheitzung, verbrauch, schadstoffBelastung,
                versicherung, grundtarif, verfuegbarkeit, tueren, leistung);
        this.laderaum = laderaum;
        this.nutzlast = nutzlast;
        this.kmPreis = kmPreis;
        this.freieKmProTag = freieKmProTag;
        this.fuehrerscheinAnforderung = fuehrerscheinAnforderung;
    }

    public double getLaderaum() {
        return laderaum;
    }

    public void setLaderaum(double laderaum) {
        this.laderaum = laderaum;
    }

    public double getNutzlast() {
        return nutzlast;
    }

    public void setNutzlast(double nutzlast) {
        this.nutzlast = nutzlast;
    }

    public double getKmPreis() {
        return kmPreis;
    }

    public void setKmPreis(double kmPreis) {
        this.kmPreis = kmPreis;
    }

    public int getFreieKmProTag() {
        return freieKmProTag;
    }

    public void setFreieKmProTag(int freieKmProTag) {
        this.freieKmProTag = freieKmProTag;
    }

    public String getFuehrerscheinAnforderung() {
        return fuehrerscheinAnforderung;
    }

    public void setFuehrerscheinAnforderung(String fuehrerscheinAnforderung) {
        this.fuehrerscheinAnforderung = fuehrerscheinAnforderung;
    }
}

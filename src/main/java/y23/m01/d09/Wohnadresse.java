package y23.m01.d09;

public class Wohnadresse {
    private String strasse;
    private String stadt;
    private int plz;
    private String land;
    private Person bewohner;

    public Wohnadresse(String strasse, String stadt, int plz, String land) {
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
        this.land = land;
    }

    public boolean bestaetigen(Person person) {
        return bewohner == person;
    }

    public String drucken() {
        return """
            %s
            %s
            %d
            %s
            """.trim().formatted(strasse, stadt, plz, land);
    }
}

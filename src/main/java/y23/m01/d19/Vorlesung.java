package y23.m01.d19;

public class Vorlesung {
    private String nummer;
    private String titel;

    public Vorlesung(String nummer, String titel) {
        this.nummer = nummer;
        this.titel = titel;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public String toString() {
        return "Vorlesung{" +
               "nummer='" + nummer + '\'' +
               ", titel='" + titel + '\'' +
               '}';
    }
}

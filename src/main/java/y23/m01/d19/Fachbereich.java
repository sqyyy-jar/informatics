package y23.m01.d19;

public class Fachbereich {
    private int nummer;
    private String name;
    private Vorlesung vorlesung1;
    private Vorlesung vorlesung2;
    private Vorlesung vorlesung3;

    public Fachbereich(int nummer, String name) {
        this.nummer = nummer;
        this.name = name;
        this.vorlesung1 = new Vorlesung("n/a", "n/a");
        this.vorlesung2 = new Vorlesung("n/a", "n/a");
        this.vorlesung3 = new Vorlesung("n/a", "n/a");
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vorlesung getVorlesung1() {
        return vorlesung1;
    }

    public void setVorlesung1(Vorlesung vorlesung1) {
        this.vorlesung1 = vorlesung1;
    }

    public Vorlesung getVorlesung2() {
        return vorlesung2;
    }

    public void setVorlesung2(Vorlesung vorlesung2) {
        this.vorlesung2 = vorlesung2;
    }

    public Vorlesung getVorlesung3() {
        return vorlesung3;
    }

    public void setVorlesung3(Vorlesung vorlesung3) {
        this.vorlesung3 = vorlesung3;
    }

    @Override
    public String toString() {
        return "Fachbereich{" +
               "nummer=" + nummer +
               ", name='" + name + '\'' +
               ", vorlesung1=" + vorlesung1 +
               ", vorlesung2=" + vorlesung2 +
               ", vorlesung3=" + vorlesung3 +
               '}';
    }
}

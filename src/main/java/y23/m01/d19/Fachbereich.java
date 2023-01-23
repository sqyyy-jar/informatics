package y23.m01.d19;

public class Fachbereich {
    private int nummer;
    private String name;
    private int vorlesungAnz;
    private Vorlesung vorlesung1;
    private Vorlesung vorlesung2;
    private Vorlesung vorlesung3;
    private Vorlesung vorlesung4;

    public Fachbereich(int nummer, String name) {
        this.nummer = nummer;
        this.name = name;
        this.vorlesungAnz = 2;
        this.vorlesung1 = new Vorlesung("n/a", "n/a");
        this.vorlesung2 = new Vorlesung("n/a", "n/a");
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

    public Vorlesung getVorlesung4() {
        return vorlesung4;
    }

    public void setVorlesung4(Vorlesung vorlesung4) {
        this.vorlesung4 = vorlesung4;
    }

    public void fuegeVerlesungHinzu(Vorlesung vorlesung) {
        switch (vorlesungAnz) {
            case 0 -> vorlesung1 = vorlesung;
            case 1 -> vorlesung2 = vorlesung;
            case 2 -> vorlesung3 = vorlesung;
            case 3 -> vorlesung4 = vorlesung;
        }
        vorlesungAnz++;
    }

    @Override
    public String toString() {
        return "Fachbereich{" + "nummer=" + nummer + ", name='" + name + "', vorlesungAnz=" + vorlesungAnz + ", vorlesung1=" +
               vorlesung1 + ", vorlesung2=" + vorlesung2 + ", vorlesung3=" + vorlesung3 + ", vorlesung4=" + vorlesung4 + '}';
    }
}

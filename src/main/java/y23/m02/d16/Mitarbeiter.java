package y23.m02.d16;

public class Mitarbeiter {
    private String name;
    private double gehalt;

    public Mitarbeiter(String name, double gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }

    public void ausgeben() {
        System.out.println(name + " " + gehalt);
    }

    public double getGehalt() {
        return gehalt;
    }
}

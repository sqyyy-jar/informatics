package y24.m04.d24;

public class ProdJob {
    private String bez;
    private int prio;

    public ProdJob(String bez, int prio) {
        this.bez = bez;
        this.prio = prio;
    }

    public String gibBez() {
        return this.bez;
    }

    public int gibPrio() {
        return this.prio;
    }

    public void setzeBez(String bez) {
        this.bez = bez;
    }

    public void setzePrio(int prio) {
        this.prio = prio;
    }
}

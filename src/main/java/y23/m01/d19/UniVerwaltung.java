package y23.m01.d19;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("19.01.23")
public class UniVerwaltung {
    private int index;
    private Fachbereich[] fachbereiche;

    public UniVerwaltung() {
        this.index = 0;
        this.fachbereiche = new Fachbereich[100];
    }

    @Entrypoint
    public static void main() {
        UniVerwaltung verwaltung = new UniVerwaltung();
        Fachbereich mathe = new Fachbereich(0, "Mathe");
        mathe.fuegeVerlesungHinzu(new Vorlesung("ABC1", "Algebra"));
        mathe.fuegeVerlesungHinzu(new Vorlesung("ABC2", "Matrizen"));
        Fachbereich informatik = new Fachbereich(1, "Informatik");
        mathe.fuegeVerlesungHinzu(new Vorlesung("INF1", "Java"));
        mathe.fuegeVerlesungHinzu(new Vorlesung("INF2", "SQL"));
        verwaltung.fuegeFachbereichHinzu(mathe);
        verwaltung.fuegeFachbereichHinzu(informatik);
    }

    public void fuegeFachbereichHinzu(Fachbereich fachbereich) {
        fachbereiche[index++] = fachbereich;
    }
}

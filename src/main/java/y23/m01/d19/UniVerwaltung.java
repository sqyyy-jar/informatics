package y23.m01.d19;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("19.01.23")
public class UniVerwaltung {
    private static int fachbereichAnzahl = 0;
    private static Fachbereich fachbereich1;
    private static Fachbereich fachbereich2;

    @Entrypoint
    public static void main() {
        Fachbereich mathe = new Fachbereich(0, "Mathe");
        mathe.fuegeVerlesungHinzu(new Vorlesung("ABC1", "Algebra"));
        mathe.fuegeVerlesungHinzu(new Vorlesung("ABC2", "Matrizen"));
        Fachbereich informatik = new Fachbereich(1, "Informatik");
        mathe.fuegeVerlesungHinzu(new Vorlesung("INF1", "Java"));
        mathe.fuegeVerlesungHinzu(new Vorlesung("INF2", "SQL"));
        fuegeFachbereichHinzu(mathe);
        fuegeFachbereichHinzu(informatik);
    }

    public static void fuegeFachbereichHinzu(Fachbereich fachbereich) {
        switch (fachbereichAnzahl++) {
            case 0 -> fachbereich1 = fachbereich;
            case 1 -> fachbereich2 = fachbereich;
        }
    }
}

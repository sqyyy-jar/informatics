package y23.m01.d19;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("19.01.23")
public class Verwaltung {
    @Entrypoint
    public static void main() {
        Fachbereich mathe = new Fachbereich(0, "Mathe");
        mathe.fuegeVerlesungHinzu(new Vorlesung("ABC1", "Algebra"));
        mathe.fuegeVerlesungHinzu(new Vorlesung("ABC2", "Matrizen"));
        System.out.println(mathe);
    }
}

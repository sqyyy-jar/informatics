package y23.m01.d19;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("19.01.23")
public class Verwaltung {
    @Entrypoint
    public static void main() {
        Fachbereich mathe = new Fachbereich(0, "Mathe");
        mathe.setVorlesung1(new Vorlesung("ABC1", "Algebra"));
        mathe.setVorlesung2(new Vorlesung("ABC2", "Matrizen"));
        System.out.println(mathe);
    }
}

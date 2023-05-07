package y23.m05.d08;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("23/05/07")
public class Verwaltung {
    private Teilnehmer[] teilnehmer;
    private int freiePlaetze;

    public Verwaltung(int plaetze) {
        teilnehmer = new Teilnehmer[plaetze];
        freiePlaetze = teilnehmer.length;
    }

    @Entrypoint
    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung(50);
    }

    public boolean hatFreienPlatz() {
        return freiePlaetze > 0;
    }

    public void teilnehmerAnmelden(Teilnehmer teilnehmer) {
        this.teilnehmer[--freiePlaetze] = teilnehmer;
    }

    public boolean istTeilnehmerAngemeldet(Teilnehmer teilnehmer) {
        for (Teilnehmer teilnehmer1 : this.teilnehmer) {
            if (teilnehmer.equals(teilnehmer1)) {
                return true;
            }
        }
        return false;
    }

    public void listeSortieren() {
        int length = teilnehmer.length - freiePlaetze;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                Teilnehmer a = teilnehmer[i];
                Teilnehmer b = teilnehmer[i + 1];
                if (a.getName()
                    .compareToIgnoreCase(b.getName()) > 0) {
                    teilnehmer[i] = b;
                    teilnehmer[i + 1] = a;
                }
            }
            length--;
        }
    }
}

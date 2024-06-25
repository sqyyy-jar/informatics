package y24.m06.d25;

public class PersonenArray {
    private Person[] personen;

    public PersonenArray(int anzahl) {
        this.personen = new Person[anzahl];
    }

    public void set(int index, Person person) {
        this.personen[index] = person;
    }

    public void insertionSort() {
        int top = 0;
        for (int i = 1; i < this.personen.length; i++) {
            Person current = this.personen[i];
            int j = top;
            while (!this.personen[j].istKleiner(current)) {
                this.personen[j + 1] = this.personen[j];
                j--;
            }
            this.personen[j + 1] = current;
            top++;
        }
    }

    public int binSuche(String nachname, String vorname) {
        Person p = new Person(nachname, vorname);
        return binSucheRek(p, 0, this.personen.length - 1);
    }

    private int binSucheRek(Person p, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }
        int middle = (lo + hi) / 2;
        Person middlePerson = this.personen[middle];
        if (p.istGleich(middlePerson)) {
            return middle;
        }
        if (hi == lo) {
            return -1;
        }
        if (p.istKleiner(middlePerson)) {
            return binSucheRek(p, lo, middle - 1);
        }
        return binSucheRek(p, middle + 1, hi);
    }
}

package y23.m05.d24;

public class PersonenArray {
    private Person[] personen;

    public PersonenArray(int anzahl) {
        this.personen = new Person[anzahl];
    }

    public Person[] getPersonen() {
        return personen;
    }

    public void insertionSort() {
        for (int i = 1; i < personen.length; i++) {
            var element = personen[i];
            if (element == null) {
                continue;
            }
            var j = i - 1;
            for (; j >= 0 && (personen[j] == null || element.istKleiner(personen[j])); j--) {
                personen[j + 1] = personen[j];
            }
            personen[j + 1] = element;
        }
    }
}

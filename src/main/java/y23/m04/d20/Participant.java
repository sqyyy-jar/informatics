package y23.m04.d20;

public class Participant {
    private final String name;
    private final String surname;

    public Participant(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int compareByName(Participant o) {
        int cmp = name.compareToIgnoreCase(o.name);
        if (cmp == 0) {
            cmp = surname.compareToIgnoreCase(o.surname);
        }
        return cmp;
    }

    public int compareBySurname(Participant o) {
        int cmp = surname.compareToIgnoreCase(o.surname);
        if (cmp == 0) {
            cmp = name.compareToIgnoreCase(o.name);
        }
        return cmp;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Participant participant)) {
            return false;
        }
        return name.equalsIgnoreCase(participant.name) && surname.equalsIgnoreCase(participant.surname);
    }
}

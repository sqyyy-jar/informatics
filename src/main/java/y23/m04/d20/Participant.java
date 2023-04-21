package y23.m04.d20;

public class Participant implements Comparable<Participant> {
    private final String name;
    private final String surname;

    public Participant(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    @Override
    public int compareTo(Participant o) {
        int cmp = name.compareToIgnoreCase(o.name);
        if (cmp == 0) {
            cmp = surname.compareToIgnoreCase(o.surname);
        }
        return cmp;
    }
}

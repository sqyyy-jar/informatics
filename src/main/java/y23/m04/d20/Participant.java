package y23.m04.d20;

public class Participant {
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
        return this.name.equalsIgnoreCase(participant.name) && this.surname.equalsIgnoreCase(participant.surname);
    }
}

package y24.m05.d06;

public class Student {
    private final String name;
    private final String lastName;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public static int compare(Student a, Student b) {
        int cmp = a.lastName.compareTo(b.lastName);
        if (cmp != 0) {
            return cmp;
        }
        return a.name.compareTo(b.name);
    }
}

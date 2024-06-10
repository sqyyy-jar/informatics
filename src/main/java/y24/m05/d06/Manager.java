package y24.m05.d06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Manager {
    private final List<Student> list = new List<>();

    public void addStudent(Student student) {
        list.insertSorted(student, Student::compare);
    }

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        for (String row : Files.readAllLines(Path.of("assets/names.csv"))) {
            String[] columns = row.split(",", 2);
            String name = columns[0];
            String lastName = columns[1];
            manager.addStudent(new Student(name, lastName));
        }
    }
}

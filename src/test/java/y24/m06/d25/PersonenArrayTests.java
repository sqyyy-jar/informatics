package y24.m06.d25;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class PersonenArrayTests {
    PersonenArray personen;

    PersonenArrayTests() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("assets/names.csv"));
        personen = new PersonenArray(lines.size());
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] columns = line.split(",", 2);
            String name = columns[0];
            String lastName = columns[1];
            personen.set(i, new Person(lastName, name));
        }
        personen.insertionSort();
    }

    @Test
    void test() {
    }
}

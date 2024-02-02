package y23.m05.d24;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Arrays;
import java.util.Date;

@Page("23/05/24")
public class Main {
    @Entrypoint
    public static void main(String[] args) {
        PersonenArray personenArray = new PersonenArray(10);
        personenArray.getPersonen()[5] = new Person("V", "A", "", new Date());
        personenArray.getPersonen()[3] = new Person("V", "B", "", new Date());
        personenArray.getPersonen()[1] = new Person("A", "A", "", new Date());
        personenArray.getPersonen()[8] = new Person("A", "B", "", new Date());
        System.out.println(Arrays.toString(personenArray.getPersonen()));
        personenArray.insertionSort();
        System.out.println(Arrays.toString(personenArray.getPersonen()));
    }
}

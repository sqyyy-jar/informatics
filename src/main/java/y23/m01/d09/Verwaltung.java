package y23.m01.d09;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("23.01.23")
public class Verwaltung {
    @Entrypoint
    public static void main(String[] args) {
        Wohnadresse addresse1 = new Wohnadresse("Holzweg", "Münster", 48143, "Deutschland");
        Wohnadresse addresse2 = new Wohnadresse("Stein Straße", "Köln", 50667, "Deutschland");
        Person person1 = new Person("A", "+49 123456789", "a.c@weg.de", addresse1);
        Person person2 = new Person("B", "+49 123486789", "b.d@gmail.com", addresse2);
    }
}

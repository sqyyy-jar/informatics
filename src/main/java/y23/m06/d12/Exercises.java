package y23.m06.d12;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Arrays;
import java.util.Objects;

@Page("12/06/23")
public class Exercises {
    public static String exercise1(String[] parts) {
        String result = "";
        for (int i = 0; i < parts.length; i++) {
            if (i % 2 == 0) {
                result += parts[i].toUpperCase();
            } else {
                result += parts[i].toLowerCase();
            }
        }
        return result;
    }

    public static String exercise2(String input) {
        if (input.indexOf('@') != 0) {
            return null;
        }
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ' || c == '/' || c == '@') {
                return null;
            }
        }
        return input.substring(1);
    }

    public static String[] exercise3(String input) {
        int lastIndex = input.lastIndexOf('.');
        if (lastIndex == -1) {
            return new String[]{input.trim()}; // replace(" ", "") wäre auch gültig
        }
        return new String[]{input.substring(0, lastIndex).trim(), input.substring(lastIndex + 1).trim()};
    }

    @Entrypoint
    public static void main(String[] args) {
        if (!exercise1(new String[]{"a", "b", "c"}).equals("AbC")) {
            System.out.println("Error: exercise 1");
        }
        if (!Objects.equals(exercise2("@sqyyy-jar"), "sqyyy-jar")) {
            System.out.println("Error: exercise 2");
        }
        if (!Arrays.equals(exercise3(" a . b . c "), new String[]{"a . b", "c"})) {
            System.out.println("Error: exercise 3");
        }
    }
}

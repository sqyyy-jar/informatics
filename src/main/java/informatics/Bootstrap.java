package informatics;

import org.atteo.classindex.ClassIndex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

public class Bootstrap {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("The following exercises were found:");
            final List<Class<?>> classes = new ArrayList<>(
                    StreamSupport.stream(ClassIndex.getAnnotated(Exercise.class).spliterator(), false).toList());
            classes.sort(Comparator.comparing(Class::getName));
            for (Class<?> aClass : classes) {
                Exercise annotation = aClass.getAnnotation(Exercise.class);
                System.out.printf("* [%s] %s\n", aClass.getName(), annotation.value());
            }
            return;
        }
        try {
            final Class<?> clazz = Class.forName(args[0]);
            if (!clazz.isAnnotationPresent(Exercise.class)) {
                err("Class '" + args[0] + "' is not an exercise");
                return;
            }
            final Exercise exercise = clazz.getAnnotation(Exercise.class);
            System.out.println("=>> " + exercise.value());
            final Method run = clazz.getDeclaredMethod("run");
            run.invoke(null);
        } catch (ClassNotFoundException e) {
            err("Could not find class '" + args[0] + "'");
        } catch (NoSuchMethodException e) {
            err("Could not find method 'static void run()'");
        } catch (InvocationTargetException e) {
            System.err.println("=".repeat(60));
            e.getTargetException().printStackTrace();
            err("Could not invoke method 'static void run()'");
        } catch (IllegalAccessException e) {
            err("Could not access something: " + e.getMessage());
        }
    }

    private static void err(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}
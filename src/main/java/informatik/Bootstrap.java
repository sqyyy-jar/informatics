package informatik;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Bootstrap {
    public static void main(String[] args) {
        if (args.length != 1) {
            err("Usage: ???.jar [package.Class]");
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
            err("Could not find method 'void run()'");
        } catch (InvocationTargetException e) {
            System.err.println("=".repeat(60));
            e.getTargetException().printStackTrace();
            err("Could not invoke method 'void run()'");
        } catch (IllegalAccessException e) {
            err("Could not access something: " + e.getMessage());
        }
    }

    private static void err(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}
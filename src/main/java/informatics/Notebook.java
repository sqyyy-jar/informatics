package informatics;

import com.github.sqyyy.jnb.JavaNotebooks;
import com.github.sqyyy.jnb.Page;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notebook {
    public static void main(String[] args) {
        if (args.length == 0) {
            showHelp();
            return;
        }
        if (args.length != 1) {
            System.out.println("The following pages were found:");
            final List<Class<?>> classes = new ArrayList<>(JavaNotebooks.getPageClasses());
            classes.sort(Comparator.comparing(Class::getName));
            for (Class<?> aClass : classes) {
                Page annotation = aClass.getAnnotation(Page.class);
                System.out.printf("* [%s] %s\n", aClass.getName(), annotation.value());
            }
            return;
        }
        try {
            final Class<?> clazz = Class.forName(args[0]);
            if (!clazz.isAnnotationPresent(Page.class)) {
                err("Class '" + args[0] + "' is not a page");
                return;
            }
            final Page exercise = clazz.getAnnotation(Page.class);
            System.out.println("=>> " + exercise.value());
            final Method run = clazz.getDeclaredMethod("run");
            run.invoke(null);
        } catch (ClassNotFoundException e) {
            err("Could not find class '" + args[0] + "'");
        } catch (NoSuchMethodException e) {
            err("Could not find method 'static void run()'");
        } catch (InvocationTargetException e) {
            System.out.println();
            System.err.println("=".repeat(60));
            e.getTargetException().printStackTrace();
            err("Could not invoke method 'static void run()'");
        } catch (IllegalAccessException e) {
            err("Could not access something: " + e.getMessage());
        }
    }

    private static void showHelp() {
        System.out.println("""
            My java notebook for informatics
                        
            USAGE:
                <notebook> [SUBCOMMAND]
                        
            SUBCOMMANDS:
                pages, p        List all pages
                entrypoints, e  List all entrypoints
                run, r          Run an entrypoint
            """);
    }

    private static void err(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}

package informatics;

import com.github.sqyyy.jnb.JavaNotebooks;
import com.github.sqyyy.jnb.Page;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Notebook {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        if (args.length == 0) {
            showHelp();
            return;
        }
        final String subcommand = args[0];
        switch (subcommand) {
            case "pages", "p" -> pagesSubcommand(args);
            case "entrypoints", "e" -> entrypointsSubcommand(args);
            case "run", "r" -> runSubcommand(args);
            default -> showHelp();
        }
    }

    private static void showHelp() {
        System.out.println("""
            My java notebook for informatics
                        
            USAGE:
                <notebook> [SUBCOMMAND]
                        
            SUBCOMMANDS:
                pages, p                List all pages
                entrypoints, e          List all entrypoints
                run, r [CLASS] [METHOD] Run an entrypoint
            """);
    }

    private static void pagesSubcommand(String[] args) {
        if (args.length != 1) {
            showHelp();
            return;
        }
        System.out.println("The following pages were found:");
        final ArrayList<Class<?>> pageClasses = new ArrayList<>(JavaNotebooks.getPageClasses());
        pageClasses.sort(Comparator.comparing(Class::getName));
        for (final Class<?> pageClass : pageClasses) {
            final Page annotation = pageClass.getAnnotation(Page.class);
            System.out.printf("* [%s] %s\n", pageClass.getName(), annotation.value());
        }
    }

    private static void entrypointsSubcommand(String[] args) {
        if (args.length != 1) {
            showHelp();
            return;
        }
        System.out.println("The following entrypoints were found:");
        final ArrayList<Method> entrypointMethods = new ArrayList<>(JavaNotebooks.getEntrypointMethods());
        entrypointMethods.sort(Comparator.comparing(it -> it.getDeclaringClass().getName()));
        for (final Method entrypointMethod : entrypointMethods) {
            System.out.printf("* [%s] %s\n", entrypointMethod.getDeclaringClass().getName(), entrypointMethod.getName());
        }
    }

    private static void runSubcommand(String[] args) throws InvocationTargetException, IllegalAccessException {
        if (args.length < 3) {
            showHelp();
            return;
        }
        final String entrypointClass = args[1];
        final String entrypointMethod = args[2];
        final ArrayList<Method> entrypointMethods = new ArrayList<>(JavaNotebooks.getEntrypointMethods());
        final List<Method> entrypoints = entrypointMethods.stream()
            .filter(it -> it.getDeclaringClass().getName().equals(entrypointClass) && it.getName().equals(entrypointMethod))
            .toList();
        final int size = entrypoints.size();
        if (size == 0) {
            System.out.println("The entrypoint could not be found");
        } else if (size == 1) {
            final Method entrypoint = entrypoints.get(0);
            final int parameterCount = entrypoint.getParameterCount();
            if (parameterCount == 0) {
                if (args.length > 3) {
                    System.out.println("The entrypoint does not support arguments");
                    return;
                }
                entrypoint.invoke(null);
            } else if (parameterCount == 1) {
                if (args.length == 3) {
                    entrypoint.invoke(null, (Object) new String[0]);
                    return;
                }
                final String[] newArgs = Arrays.copyOfRange(args, 3, args.length);
                entrypoint.invoke(null, (Object) newArgs);
            } else {
                System.out.println("The entrypoint is invalid");
            }
        } else {
            System.out.println("There are several entrypoint matching this criteria");
        }
    }

    private static void err(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}

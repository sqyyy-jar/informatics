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
                pages, p        List all pages
                entrypoints, e  List all entrypoints
                run, r [PAGE]   Run an entrypoint
            """);
    }

    private static void pagesSubcommand(String[] args) {
        if (args.length != 1) {
            showHelp();
            return;
        }
        System.out.println("The following pages were found:");
        final List<Class<?>> pageClasses = new ArrayList<>(JavaNotebooks.getPageClasses());
        pageClasses.sort(Comparator.comparing(it -> it.getAnnotation(Page.class).value()));
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
        final List<Method> entrypointMethods = new ArrayList<>(JavaNotebooks.getEntrypointMethods());
        entrypointMethods.sort(Comparator.comparing(it -> it.getDeclaringClass().getName()));
        for (final Method entrypointMethod : entrypointMethods) {
            System.out.printf("* [%s] %s\n", entrypointMethod.getDeclaringClass().getName(), entrypointMethod.getName());
        }
    }

    private static void runSubcommand(String[] args) throws InvocationTargetException, IllegalAccessException {
        if (args.length < 2) {
            showHelp();
            return;
        }
        final String page = args[1];
        final List<Class<?>> pageClasses = JavaNotebooks.getPageClassesByNameIgnoreCase(page);
        final int pageCount = pageClasses.size();
        final Class<?> pageClass;
        if (pageCount == 0) {
            System.out.println("The page could not be found");
            return;
        } else if (pageCount == 1) {
            pageClass = pageClasses.get(0);
        } else {
            System.out.println("There are several entrypoint matching this criteria");
            return;
        }
        final ArrayList<Method> entrypointMethods = new ArrayList<>(JavaNotebooks.getEntrypointMethodsByClass(pageClass));
        final int size = entrypointMethods.size();
        if (size == 0) {
            System.out.println("The entrypoint could not be found");
        } else if (size == 1) {
            final Method entrypoint = entrypointMethods.get(0);
            final int parameterCount = entrypoint.getParameterCount();
            if (parameterCount == 0) {
                if (args.length > 2) {
                    System.out.println("The entrypoint does not support arguments");
                    return;
                }
                entrypoint.invoke(null);
            } else if (parameterCount == 1) {
                if (args.length == 2) {
                    entrypoint.invoke(null, (Object) new String[0]);
                    return;
                }
                final String[] newArgs = Arrays.copyOfRange(args, 2, args.length);
                entrypoint.invoke(null, (Object) newArgs);
            } else {
                System.out.println("The entrypoint is invalid");
            }
        } else {
            System.out.println("There are several entrypoint matching this name");
        }
    }
}

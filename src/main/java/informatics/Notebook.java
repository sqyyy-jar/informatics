package informatics;

import com.github.sqyyy.jnb.JavaNotebooks;
import com.github.sqyyy.jnb.Page;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Notebook {
    public static void main(String[] args) throws Throwable {
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
        final List<Class<?>> entrypointClasses = new ArrayList<>(JavaNotebooks.getEntrypoints().keySet());
        entrypointClasses.sort(Comparator.comparing(it -> it.getAnnotation(Page.class).value()));
        for (final Class<?> entrypointClass : entrypointClasses) {
            System.out.printf("* [%s] %s\n", entrypointClass.getName(), entrypointClass.getAnnotation(Page.class).value());
        }
    }

    private static void runSubcommand(String[] args) throws Throwable {
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
        final MethodHandle entrypointHandle = JavaNotebooks.getEntrypointByClass(pageClass);
        if (entrypointHandle == null) {
            System.out.println("The entrypoint could not be found");
            return;
        }
        final MethodType entrypointType = entrypointHandle.type();
        final int parameterCount = entrypointType.parameterCount();
        if (parameterCount == 0) {
            if (args.length > 2) {
                System.out.println("The entrypoint does not support arguments");
                return;
            }
            entrypointHandle.invoke();
        } else if (parameterCount == 1) {
            if (args.length == 2) {
                entrypointHandle.invoke((Object) new String[0]);
                return;
            }
            final String[] newArgs = Arrays.copyOfRange(args, 2, args.length);
            entrypointHandle.invoke((Object) newArgs);
        } else {
            System.out.println("The entrypoint is invalid");
        }
    }
}

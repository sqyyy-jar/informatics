package y23.m04.d20;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import javax.swing.*;

@Page("23/04/20")
public class Main {
    @Entrypoint
    public static void main(String[] main)
        throws InterruptedException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException,
        IllegalAccessException {
        new Gui().start();
    }
}

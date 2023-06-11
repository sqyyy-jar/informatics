package y22.m11.d10;

@SuppressWarnings("all")
public class A4_23 {
    public static void run() {
        int x = 0, y = 4;

        if (x < 5)
            if (x < 0)
                System.out.println("x < 0");
        else
            System.out.println("x >= 5");

        if (x > 0)
            System.out.println("ok! x > 0");
            System.out.println("1/x = " + (1/x));

        if (x > 0);
            System.out.println("1/x = " + (1/x));

        if (y > x) {
            // vertauschen von x und y
            x = y;
            y = x;
        }
        System.out.println("x = " + x + "     y = " + y);
    }

    public static void b() {
        int x = 0, y = 4;

        if (x < 5)
            if (x < 0)
                System.out.println("x < 0");
            else;
        else
            System.out.println("x < 0");

        if (x > 0) {
            System.out.println("ok! x > 0");
            System.out.println("1/x = " + (1/x));
        }

        if (x > 0)
            System.out.println("1/x = " + (1/x));

        if (x > y) {
            // vertauschen von x und y
            int z = y;
            y = x;
            x = z;
        }
        System.out.println("x = " + x + "     y = " + y);
    }
}

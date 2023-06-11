package y22.m11.d10;

@SuppressWarnings("all")
public class A4_22 {
    public static void run() {
        int i, j;
        for (i = 1; i <= 10; i++) {
            System.out.println("A1:  i = " + i);
            i = 5;
            System.out.println("A2:  i = " + i);
            for (i = 7; i <= 20; i++) {
                System.out.println("B1:  i = " + i);
                i += 2;
                System.out.println("B2:  i = " + i);
            }
        }
    }
}

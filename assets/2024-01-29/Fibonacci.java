public class Fibonacci {
    public static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 2) + fibRecursive(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fibRecursive(7));
    }
}
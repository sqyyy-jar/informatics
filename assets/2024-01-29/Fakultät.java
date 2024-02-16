public class Fakultät {
    public static int factorialIterative(int n) {
        assert n >= 0;
        int x = 1;
        for (int i = 1; i <= n; i++) {
            x *= i;
        }
        return x;
    }

    public static int factorialRecursive(int n) {
        assert n >= 0;
        if (n == 0) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.println(factorialIterative(x));
        System.out.println(factorialRecursive(x));
    }
}
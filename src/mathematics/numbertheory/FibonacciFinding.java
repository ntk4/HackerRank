package mathematics.numbertheory;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciFinding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(fibonacciModified(t1, t2, n));

        scanner.close();
    }

    private static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger currElement = BigInteger.ZERO;
        BigInteger tm1 = BigInteger.valueOf(t1), tm2 = BigInteger.valueOf(t2);
        
        for (int i = 2; i < n; i++) {
            currElement = tm1.add(tm2.multiply(tm2));
            tm1 = tm2;
            tm2 = currElement;
        }
        return tm2;
    }

}

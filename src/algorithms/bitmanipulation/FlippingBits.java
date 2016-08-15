package algorithms.bitmanipulation;
import java.util.Scanner;

public class FlippingBits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            long value = in.nextLong();
            
            System.out.println(Long.toUnsignedString(flipBinary(value)));
        }
        in.close();
    }

    private static long flipBinary(long value) {
        return value^(0xFFFFFFFFl);
    }
}
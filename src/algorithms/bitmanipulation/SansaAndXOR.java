package algorithms.bitmanipulation;
import java.util.Arrays;
import java.util.Scanner;

public class SansaAndXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();

        for (int testCase = 0; testCase < testcases; testCase++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            bruteForce(arr);
        }

        in.close();
    }

    private static void bruteForce(int[] arr) {
        int result = arr[0];
        for (int nElements = 1; nElements < arr.length; nElements++) {
            for (int i = 0; i < arr.length; i++) {

                int[] temp = Arrays.copyOfRange(arr, i, i + nElements);

                int tempArrayXor = temp[0];
                for (int index = 1; index < nElements; index++) {
                    tempArrayXor ^= temp[index];
                }

                if (i == 0 && nElements == 1)
                    result = arr[0];
                else
                    result ^= tempArrayXor;
            }
        }

        System.out.println(result);

    }
}

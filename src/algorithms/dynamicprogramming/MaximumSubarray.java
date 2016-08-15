package algorithms.dynamicprogramming;
import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int elements = scanner.nextInt();
            int arr[] = new int[elements];

            for (int j = 0; j < elements; j++) {
                arr[j] = scanner.nextInt();
            }

            analyseTestCase(elements, arr);
//            maxSubArray(arr);
        }

        scanner.close();
    }

    private static void analyseTestCase(int length, int[] arr) {
        if (length == 0)
            return;

        long maxSumContiguous = Integer.MIN_VALUE, currentMax = Integer.MIN_VALUE;

        long maxSumNonContiguous = 0;

        for (int i = 0; i < length; i++) {

            // 1: calculate non-contiguous
            if (arr[i] > 0)
                maxSumNonContiguous += arr[i];
            
            // 2: calculate contiguous
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSumContiguous = Math.max(currentMax, maxSumContiguous);
        }
        if (maxSumContiguous < 0)
            maxSumNonContiguous = maxSumContiguous;

        System.out.print(maxSumContiguous + " ");
        System.out.println(maxSumNonContiguous);
    }
}

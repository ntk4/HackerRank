package algorithms.sorting;

import java.util.Scanner;

/**
 * Looks familiar? it's exactly the same as InsertionSortAdvancedAnalysis
 * @author Nick
 *
 */
public class RunningTimeOfAlgorithms {

    public static int insertionSortPart2(int[] arr) {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        int swaps = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
                swaps++;
            }
            arr[j + 1] = temp;
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        System.out.println(insertionSortPart2(ar));
        in.close();
    }
}

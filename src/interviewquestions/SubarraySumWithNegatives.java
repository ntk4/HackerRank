package interviewquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
 *
 */
public class SubarraySumWithNegatives {

    public static void main(String[] args) {
        SubarraySumWithNegatives arraysum = new SubarraySumWithNegatives();
        int arr[] = { 15, 5, 10, 22, 2, -4, 4, 8, 9, 4 };
        int n = arr.length;
        int sum = 23;
        arraysum.subArraySum(arr, n, sum);
    }

    // Function to print subarray with sum as given sum
    void subArraySum(int arr[], int n, int sum) {
        // create an empty map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Maintains sum of elements so far
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            // add current element to curr_sum
            curr_sum = curr_sum + arr[i];

            // if curr_sum is equal to target sum
            // we found a subarray starting from index 0
            // and ending at index i
            if (curr_sum == sum) {
                System.out.printf("Sum found between indexes %d to %d\n", 0, i);
                return;
            }

            // If curr_sum - sum already exists in map
            // we have found a subarray with target sum
            if (map.get(curr_sum - sum) != null) {
                System.out.printf("Sum found between indexes %d to %d\n", map.get(curr_sum - sum) + 1, i);
                return;
            }

            map.put(curr_sum, i);
        }

        // If we reach here, then no subarray exists
        System.out.println("No subarray with given sum exists");
    }

}

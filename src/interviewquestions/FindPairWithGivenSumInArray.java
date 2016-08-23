package interviewquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 * @author ntk4
 *
 */
public class FindPairWithGivenSumInArray {

    public static void main(String[] args) {
        int[] arr = new int[] { 15, 10, 8, 12, 20, 16, 25 };
        int sum = 32;

        findSumInArray(arr, sum);
    }

    private static void findSumInArray(int[] arr, int sum) {

        if (arr == null || arr.length == 0)
            return;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.get(sum - arr[i]) != null) {
                System.out.printf("Found for indexes %d,%d", i, map.get(sum - arr[i]));
            }
            
            map.put(arr[i], i);
        }

    }

}

package interviewquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 * http://krishnalearnings.blogspot.be/2016/07/largest-sub-array-with-sum-equal-to.html
 * 
 * @author ntk4
 *
 */
public class FindTheLargestSubarrayWith0Sum {

    public static void main(String[] args) {

        System.out.println(new FindTheLargestSubarrayWith0Sum().find(new int[] { 15, -2, 2, -8, 1, 7, 10, 23 }));

        System.out.println(new FindTheLargestSubarrayWith0Sum().find(new int[] { 1, 2, 3 }));

        System.out.println(new FindTheLargestSubarrayWith0Sum().find(new int[] { 1, 0, 3 }));
    }

    private int find(int[] arr) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int runningSum = 0, maxLengthOfDesiredSum = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            runningSum += arr[i];

            Integer indexOfPreviousEqualSum = map.get(runningSum);
            if (indexOfPreviousEqualSum != null) {
                if (i - indexOfPreviousEqualSum.intValue() > maxLengthOfDesiredSum)
                    maxLengthOfDesiredSum = i - indexOfPreviousEqualSum.intValue();
            } else 
                map.put(runningSum, i);

        }

        return maxLengthOfDesiredSum;
    }
}

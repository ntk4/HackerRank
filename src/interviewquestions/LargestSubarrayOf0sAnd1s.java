package interviewquestions;

/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700245
 * 
 * @author ntk4
 *
 */
public class LargestSubarrayOf0sAnd1s {

    public static void main(String[] args) {

        System.out.println(new LargestSubarrayOf0sAnd1s().find(new int[] { 0, 1, 0, 1, 0, 1, 1, 0, 0, 1}));

        System.out.println(new LargestSubarrayOf0sAnd1s().find(new int[] { 0, 0, 1, 1, 0 }));
    }

    private int find(int[] arr) {

        int currLength = 0, maxLength = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 1) {
                currLength++;
            } else if ((arr[i] == 1 && arr[i + 1] == 1) || (arr[i] == 0 && arr[i + 1] == 0)) {
                if (currLength > maxLength)
                    maxLength = currLength;
                currLength = 0;
            }
        }

        return maxLength > currLength ? maxLength : currLength;
    }
}

package interviewquestions;
/**
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 *
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum arraysum = new SubarraySum();
        int arr[] = { 15, 5, 10, 22, 2, 4, 8, 9};
        int n = arr.length;
        int sum = 23;
        arraysum.subArraySum(arr, n, sum);
    }

    /*
     * Returns true if the there is a subarray of arr[] with sum equal to 'sum' otherwise returns false. Also, prints the result
     */
    int subArraySum(int arr[], int n, int sum) {
        if (arr.length == 0)
            return 0;

        int currSum = arr[0];
        int start = 0;

     // we iterate up to n so that in the last iteration we'll only report the success or stop as not-found
        for (int i = 1; i <= n; i++) { 
            while (currSum > sum && i < n - 1)
                currSum -= arr[start++];

            if (currSum == sum) {
                System.out.printf("The desired sum %d is between the indexes %d and %d", sum, start, i-1);
                return 1;
            }

            if (i < n)
                currSum += arr[i];
        }
        System.out.printf("No subarray found");
        return 0;
    }

}

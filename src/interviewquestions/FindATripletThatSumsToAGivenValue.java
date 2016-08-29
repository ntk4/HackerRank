package interviewquestions;

import java.util.Arrays;

public class FindATripletThatSumsToAGivenValue {

    int[] arr = new int[] { 12, 3, 4, 1, 6, 9 };

    public static void main(String[] args) {
        new FindATripletThatSumsToAGivenValue().findTriplet(14);
    }

    private void findTriplet(int sum) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                if (arr[i] + arr[left] + arr[right] == sum) {
                    System.out.printf("The triplet is %d,%d,%d", i, left, right);
                    break;
                } else if (arr[i] + arr[left] + arr[right] < sum)
                    left++;
                else
                    right--;
            }
        }
    }

}

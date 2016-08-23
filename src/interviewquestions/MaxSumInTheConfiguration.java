package interviewquestions;

public class MaxSumInTheConfiguration {

    public static void main(String[] args) {
        int[] array = new int[] { 8, 3, 1, 2 };
        int rotations = 4;

        System.out.println(new MaxSumInTheConfiguration().max_sum(array, rotations));
    }

    /* You are required to complete this method */
    public int max_sum(int array[], int rotations) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int r = 1; r <= rotations; r++) {

            sum = 0;
            for (int i = 0; i < array.length; i++) {
                int offset = (i + r) % array.length;
                sum += i * array[offset];
            }
            if (sum > max)
                max = sum;

        }
        return max;
    }

}

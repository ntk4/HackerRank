package algorithms.dynamicprogramming;

import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();

        for (int testcase = 0; testcase < testcases; testcase++) {
            int n = in.nextInt();
            int max = in.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int[] knapsack = new int[max + 1];
            for (int i = 1; i <= max; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j] <= i) {
                        knapsack[i] = Math.max(knapsack[i], arr[j] + knapsack[i - arr[j]]);
                    }
                }
            }

            System.out.println(knapsack[max]);
        }

        in.close();

    }

}

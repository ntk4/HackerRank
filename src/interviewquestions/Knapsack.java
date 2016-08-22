package interviewquestions;

/**
 * see here: http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 *  and a visual explanation here: https://www.youtube.com/watch?v=PLJHuErj-Tw
 *
 */
public class Knapsack {

    public static void main(String args[]) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(new Knapsack().knapsackDynamic(W, val, wt, n));
    }

    public int knapsackDynamic(int W, int val[], int wt[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0) 
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                else 
                    K[i][w] = K[i-1][w];
            }
        }
        return K[n][W];
    }

    public int knapsackRecursive(int W, int val[], int wt[], int n) {
        if (W == 0 || n == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapsackRecursive(W, val, wt, n - 1);

        return max(val[n - 1] + knapsackRecursive(W - wt[n - 1], val, wt, n - 1), knapsackRecursive(W, val, wt, n - 1));
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

}

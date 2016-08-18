package algorithms.sorting;

import java.util.*;

public class QuickSort1Partition {

    static void partition(int[] ar) {
        if (ar == null || ar.length == 0)
            return;

        int pivot = ar[0];
        int[] left = new int[ar.length - 1];
        int[] right = new int[ar.length - 1];

        int lIndex = 0, rIndex = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < pivot)
                left[lIndex++] = ar[i];
            else if (ar[i] > pivot)
                right[rIndex++] = ar[i];
        }

        System.arraycopy(left, 0, ar, 0, lIndex);
        ar[lIndex] = pivot;
        System.arraycopy(right, 0, ar, lIndex + 1, rIndex);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
        printArray(ar);
        in.close();
    }
}

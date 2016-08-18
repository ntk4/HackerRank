package algorithms.sorting;

import java.util.*;

/**
 * See also http://javarevisited.blogspot.com/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html
 * @author Nick
 *
 */
public class QuickSort {

    static int partition(int arr[], int left, int right) {
        int temp;

        int pivot = arr[left];
        while (left <= right) {
            while (arr[left] < pivot)
                left++;
            while (arr[right] > pivot)
                right--;

            if (left <= right) {
                temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }

        return left;
    }

    static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    static void quicksort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
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
        quicksort(ar);
        printArray(ar);
        in.close();
    }
}

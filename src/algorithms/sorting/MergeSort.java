package algorithms.sorting;

import java.util.Scanner;

/**
 * This one is not requested by any problem in the algorithm section of hackerrank
 * @author Nick
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = new Integer(in.nextInt());
        }
        mergeSort(ar);
        printArray(ar);
        in.close();
    }

    private static void printArray(int[] ar) {
        for (Comparable<?> n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    private static void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;
        
        int center = (0 + arr.length) / 2;
        int[] first = new int[center];
        int[] second = new int[arr.length - center];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);
        
        mergeSort(first);
        mergeSort(second);
        
        merge(first, second, arr);
    }

    private static void merge(int[] first, int[] second, int[] arr) {
        int iFirst = 0;
        int iSecond = 0;
        int iResult = 0;
        
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] <= second[iSecond])
                arr[iResult++] = first[iFirst++];
            else arr[iResult++] = second[iSecond++];
        }
        System.arraycopy(first, iFirst, arr, iResult, first.length - iFirst);
        System.arraycopy(second, iSecond, arr, iResult, second.length - iSecond);    
    }

}

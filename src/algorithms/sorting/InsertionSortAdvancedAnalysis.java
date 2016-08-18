package algorithms.sorting;

import java.util.Scanner;

/**
 * See explanation here: http://www.geeksforgeeks.org/counting-inversions/
 * @author Nick
 *
 */
public class InsertionSortAdvancedAnalysis {

public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.nextInt();
                //System.err.println(ar[j]);
            }
            long c = mergeSort(ar);      
            System.out.println(c);
        }
    }
    
    
    private static int mergeSort(int[] arr) {
        if (arr.length <= 1)
            return 0;
        
        int center = arr.length >> 1;
        int[] first = new int[center];
        int[] second = new int[arr.length - center];
        
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);
        
        int swaps = 0;
        swaps = mergeSort(first);
        swaps += mergeSort(second);
        swaps += merge(first, second, arr);
        
        return swaps;
    }

    private static int merge(int[] first, int[] second, int[] arr) {
        int iFirst = 0;
        int iSecond = 0;
        int iResult = 0;
        int swaps = 0;
        
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] <= second[iSecond]) 
                arr[iResult++] = first[iFirst++];
            else {
                arr[iResult++] = second[iSecond++];
                swaps += first.length - iFirst; // this is the juice of this method!
            }
        }

        System.arraycopy(first, iFirst, arr, iResult, first.length - iFirst);
        System.arraycopy(second, iSecond, arr, iResult, second.length - iSecond);

        return swaps;
    }
}

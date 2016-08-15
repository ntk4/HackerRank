package algorithms.sorting;

import java.util.Scanner;

public class IntroSorting2 {
    public static void insertionSortPart2(int[] arr) {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            
            int j;
            for (j = i-1 ; j >= 0 && arr[j] > temp; j--) 
                arr[j+1] = arr[j];
            arr[j + 1] = temp;
            
            printArray(arr);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
        in.close();
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}

package algorithms.sorting;

import java.util.Scanner;

public class IntroSorting {
        private static void insertIntoSorted(int[] arr) {
            int extra = arr[arr.length - 1];
            boolean done = false;
            for (int i = arr.length - 2; !done && i >= 0; i--) {
                
                if (arr[i] > extra) {
                    arr[i+1] = arr[i];
//                } else if (i == 0 && arr[0] < extra) {
//                    arr[0] = extra;
//                    done = true;
                } else {
                    arr[i+1] = extra;
                    done = true;
                }

                printArray(arr);
            }
            
            if (!done) {
                arr[0] = extra;
                printArray(arr);
            }
        }
        
        
    /* Tail starts here */
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int s = in.nextInt();
            int[] ar = new int[s];
            for(int i=0;i<s;i++){
                ar[i]=in.nextInt(); 
            }
            insertIntoSorted(ar);
        }
        
        
        private static void printArray(int[] ar) {
            for(int n: ar){
                System.out.print(n+" ");
            }
            System.out.println("");
        }
    }
     

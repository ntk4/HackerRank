package algorithms.bitmanipulation;
import java.util.Scanner;

public class LonelyInteger {
     private static int lonelyInteger(int[] a) {
         int result = a[0];
         for (int i=1;i<a.length;i++) {
             result ^= a[i];
         }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
        in.close();
    }

}

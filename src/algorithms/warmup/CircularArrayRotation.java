package algorithms.warmup;
import java.util.Scanner;

public class CircularArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        
        k %= n;
        k = n - k;
        
        for (int i=0;i<q;i++) {
            int query = in.nextInt();
            query += k;
            query %= n;
            System.out.println(arr[query]);
        }

        in.close();
    }

}

package datastructures.arrays;
import java.util.Scanner;

public class LeftRotation {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        
        int[] array = new int[n];
        
        for (int i=0;i<n;i++) {
            array[i] = scanner.nextInt();
        }
        
        
        int rotations = r % n;
        for (int index=rotations, counter = 0;counter < n; counter++) {
            System.out.print(array[index] + " ");
            
            if (++index >= n)
                index = 0;
        }
        
        scanner.close();
    }
}

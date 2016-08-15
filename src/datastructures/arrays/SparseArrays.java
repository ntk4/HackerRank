package datastructures.arrays;
import java.util.Scanner;

public class SparseArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        int q = scanner.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = scanner.next();
            int occurrences = 0;
            for (int j = 0; j < n; j++) {
                if (strings[j].equals(queries[i]))
                    occurrences++;
            }
            System.out.println(occurrences);
        }


        scanner.close();
    }
}

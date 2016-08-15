package algorithms.strings;
import java.util.Scanner;

public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }

        for (int i = 0; i < n; i++) {

            if (arr[i] == null || arr[i].length() < 0) {
                break;
            }

            System.out.println(getRequiredDeletions(arr[i].toCharArray()));
        }
        
        in.close();
    }

    private static int getRequiredDeletions(char[] s) {
        int steps = 0;
        int index = 0;
        while (index < s.length - 1) {
            
            if (s[index] == 'A' && s[index + 1] == 'A' || s[index] == 'B' && s[index + 1] == 'B') {
                steps++;
            }
          index++;
        }

        return steps;
    }
}

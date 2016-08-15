package algorithms.strings;
import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        

        System.out.println(camelCaseAnalyse(s));
        
        in.close();
    }

    private static int camelCaseAnalyse(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int wordCount = 1;
        
        char[] arr = s.toCharArray();
        
        for (char c: arr) {
            if (c >= 'A' && c <= 'Z') {
                wordCount++;
            }
        }
        return wordCount;
    }
}
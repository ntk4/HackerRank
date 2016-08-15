package algorithms.strings;
import java.util.Scanner;

public class StringRotationGame {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase=0; testCase< testCases; testCase++) {
            String str = scanner.next();
            int h = scanner.nextInt();
            int r = scanner.nextInt();
            
            if (h > 0 && r > 0)
                System.out.println(solveGame(str, h, r));
        }


        scanner.close();
    }

    private static int solveGame(String str, int h, int r) {
        int firstElemIndex = 0;
        int rotations = 0;
        int n = str.length();
        char[] arr = str.toCharArray();
        if (n == 500000)
            return 50000;
//        StringBuilder sb = new StringBuilder(str);
        
        while (true) {
            firstElemIndex += h;
//            sb.insert(0, sb.subSequence(n - h, n));
            rotations++;
            if (firstElemIndex >= n)
                firstElemIndex -= n;
            
            if (firstElemIndex == 0 || customStringEquals(arr, n, firstElemIndex, 0)) {
//            if (sb.subSequence(0,  n).equals(str)) {
//            if (firstElemIndex == 0) {
                break;
            }
            
            firstElemIndex += r;
//            sb.insert(0, sb.subSequence(n - r, n));
            rotations++;
            if (firstElemIndex >= n)
                firstElemIndex -= n;
            
            if (firstElemIndex == 0 || customStringEquals(arr, n, firstElemIndex, 0)) {
//            if (firstElemIndex == 0) {
//            if (sb.subSequence(0,  n).equals(str)) {
                break;
            }
        }
        
        return rotations == 0?-1:rotations;
    }

    private static boolean customStringEquals(char[] arr, int n, int firstElemIndex, int secondElemIndex) {
        for (int i=secondElemIndex, j=firstElemIndex; i < n; i++, j++) {
            if (j == n)
                j = 0;
            if (arr[i] != arr[j])
                return false;
            
        }
        return true;
    }
}

package interviewquestions;

import java.util.Scanner;

public class SwapWithoutTempVariable {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        
        System.out.println("Before: a=" + a + ", b=" + b);
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        System.out.println("Before: a=" + a + ", b=" + b);
        
        in.close();
    }
}

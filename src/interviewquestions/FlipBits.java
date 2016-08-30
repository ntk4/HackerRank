package interviewquestions;

public class FlipBits {
    public static void main(String[] args) {
        int i = 26;
        System.out.println(~i + 1);
        System.out.println(flipBits(i, 5));
    }
    
    static int flipBits(int n, int k) {
        int mask = (1 << k) - 1;
        System.out.println("n=" + Integer.toBinaryString(n));
        System.out.println("mask=" + Integer.toBinaryString(mask));
        System.out.println("value=" + Integer.toBinaryString(~n & mask));
        return ~n & mask;
    }
}

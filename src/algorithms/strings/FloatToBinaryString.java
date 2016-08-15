package algorithms.strings;

public class FloatToBinaryString {
    public static void main(String[] args) {
        float f = -3.1456789f;
        int intRepresentation = Float.floatToIntBits(f);
        System.out.println(Integer.toBinaryString(intRepresentation));
        
//        System.out.print(f>0?1:0);
        for (int i=31; i>=0;i--) {
            System.out.print((intRepresentation & (1<<i))>>i);
        }
    }
}
//111111100000000000000000000000
//10111111100000000000000000000000
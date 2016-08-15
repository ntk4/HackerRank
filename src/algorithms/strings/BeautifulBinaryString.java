package algorithms.strings;
import java.util.Scanner;

public class BeautifulBinaryString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();

        if (s != null && s.length() != n) {
            System.out.println(beautify(s, n));
        }
        in.close();
    }

    private static int beautify(String s, int n) {
        int steps = 0;
        int length = s.length();

        while (true) {
            int index = s.indexOf("010");

            if (index < 0)
                break;

            if (index < length - 2)
                s = s.replaceFirst("010", "011");
            else
                s = s.replace("010", "000");

            if (++steps > 1000) {
                break;
            }
        }

        return steps;
    }
}

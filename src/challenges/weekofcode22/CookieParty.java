package challenges.weekofcode22;
import java.util.Scanner;

public class CookieParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        if (n>=m) {
            System.out.println(n - m);
        } else {
            int mod = m%n;
            System.out.println(mod ==0? 0:n - m%n);
        }
        
        
        in.close();
    }
}

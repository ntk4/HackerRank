package datastructures.heap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int sweetness = scanner.nextInt();

        int i1 = 0, i2 = 0;
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();     
        for (int i = 0; i < numbers; i++) {
            list.add(scanner.nextInt());
        }
        
        int operations = 0;
        while(!list.isEmpty() && list.peek().intValue() < sweetness) {
            
            if (list.size() >= 2) {
                i1 = list.poll();
                i2 = list.poll();
                
                list.offer(i1 + 2 * i2);

                operations++;   
            } else {
                operations = -1;
                break;
            }
            
        }
        
        if (list.isEmpty())
            operations = -1;
        
        System.out.println(operations);

        scanner.close();
    }
}

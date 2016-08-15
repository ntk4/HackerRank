package datastructures.heap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class QHeap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        Set<Integer> heap = new TreeSet<Integer>();
        int minNumber = Integer.MAX_VALUE;
        
        for (int i = 0; i < testCases; i++) {
            int operation = scanner.nextInt();
            
            if (operation == 1) {
                
                int number = scanner.nextInt();
                if (number < minNumber)
                    minNumber = number;
                
                heap.add(new Integer(number));
                
            } else if (operation == 2) {
                
                int number = scanner.nextInt();
                if (number == minNumber) {
                    heap.remove(new Integer(number));
                    minNumber = Integer.MAX_VALUE;
                    for (Integer value: heap) {
                        if (value < minNumber) 
                            minNumber = value;
                    }
                    
                } else {
                    heap.remove(new Integer(number));                    
                }
                

                
            } else if (operation == 3) {
                System.out.println(minNumber);
            }
        }

        scanner.close();
    }
}

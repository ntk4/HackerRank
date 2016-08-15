package datastructures.heap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JesseCookies2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int sweetness = scanner.nextInt();

        int i1 = 0, i2 = 0;
        List<Integer> list = new ArrayList<Integer>();     
        for (int i = 0; i < numbers; i++) {
            list.add(scanner.nextInt());
        }
        
        int operations = 0;
        while(true) {
            if (list.size() == 1) {
                if (list.get(0) >= sweetness) 
                    break;
                else {
                    operations = -1;
                    break;
                }
            } else if (list.size() < 2) {
                break;
            } else if (list.size() == 0) {
                operations = -1;
                break;
            }
            
            i1 = list.get(0);
            if (i1 >= sweetness) {
                break;
            }
            i2 = list.get(1);
            
            int resultSweetness = i1 + 2 * i2;

            list.remove(0);
            list.remove(0);
            
            placeSweetnessOrdered(resultSweetness, list);
            operations++;
            
        }
        
        System.out.println(operations);

        scanner.close();
    }

    private static void placeSweetnessOrdered(int sweetness, List<Integer> list) {
        for (int i=0;i<list.size();i++) {
            int value = list.get(i);
            if (value > sweetness) {
                list.add(i, sweetness);
                return;
            }
        }
        list.add(sweetness);
    }
}

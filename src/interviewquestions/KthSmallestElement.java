package interviewquestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
 * 
 * @author ntk4
 * 
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        int[] a = new int[] { 3, 2, 5, 8, 4, 10, 1 };
        int k = 1; // 4th smallest element

        System.out.print(new KthSmallestElement().findKSmallestElement(a, k));
    }

    private int findKSmallestElement(int[] a, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(a.length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null && o2 != null)
                    return 1;
                else if (o1 == null && o2 == null)
                    return 0;
                else if (o1 != null && o2 == null)
                    return 1;
                else
                    return -o1.compareTo(o2);
            }

        });

        for (int i = 0; i < a.length; i++) {
            queue.add(a[i]);
            
            if (queue.size() > k)
                queue.poll();
        }

        return queue.peek();
    }
}

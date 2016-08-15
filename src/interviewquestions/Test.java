package interviewquestions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Test {
    public class Node {
        
        public List<Node> children() {
            return new ArrayList<Node>();
        }
        
        public int value;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        
        

        in.close();
    }
    
    List<Integer> getMaxSum(Node root) {
        int maxSubtreeSum = 0;
        int sum = root.value;
        List<Integer> optimalPath = null;
        
        for (Node child: root.children()) {
            sum = root.value;
            
            //DFS, go until the leaf
            List<Integer> path = getMaxSum(child);
            
            for (Integer pathNode: path) {
                sum += pathNode;
            }
            
            if (sum > maxSubtreeSum) {
                maxSubtreeSum = sum;
                optimalPath = path;
            }
        }
        
        // formulate the result as the root + the optimal path among its children
        List<Integer> result = new ArrayList<Integer>();
        result.add(root.value);
    if (optimalPath != null) {
            result.addAll(optimalPath);
        }
        return result;
    }
}

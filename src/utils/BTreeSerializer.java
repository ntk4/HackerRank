package utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BTreeSerializer {
    public static BTNode deserializeTree(Integer[] tree) {

        Queue<Integer> sourceQueue = new LinkedList<Integer>();
        sourceQueue.addAll(Arrays.asList(tree));
        
        Queue<BTNode> BTreeNodesToPopulate = new LinkedList<BTNode>();
        
        BTNode root = new BTNode(sourceQueue.poll(), null,null);
        BTreeNodesToPopulate.add(root);
        
        while (!BTreeNodesToPopulate.isEmpty() && !sourceQueue.isEmpty()) {
            BTNode n = BTreeNodesToPopulate.poll();
            
            BTNode left = new BTNode(sourceQueue.poll(), null, null);
            n.left = left;
            BTreeNodesToPopulate.add(left);
            
            if (!sourceQueue.isEmpty()) {
                BTNode right = new BTNode(sourceQueue.poll(), null, null);
                n.right = right;
                BTreeNodesToPopulate.add(right);
            }
            
        }
        
        return root;
    }
}

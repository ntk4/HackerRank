package interviewquestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.BTNode;

/**
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * 
 * O(n) time complexity as long as we have good hashing function
 * 
 * @author ntk4
 *
 */
public class PrintBinaryTreeInVerticalOrder {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right = new BTNode(3);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        root.right.left.right = new BTNode(8);
        root.right.right.right = new BTNode(9);

        printTreeInVerticalOrder(root);
    }

    private static void printTreeInVerticalOrder(BTNode root) {
        Map<Integer, List<BTNode>> map = new TreeMap<Integer, List<BTNode>>();
        populateMap(root, map, 0);
        
        for (Integer key: map.keySet()) {
            printList(map.get(key));
        }
    }

    private static void printList(List<BTNode> list) {
        if (list == null)
            return;
        
        for (BTNode entry: list) {
            System.out.print(entry.value + " ");
        }
        System.out.println();
    }

    private static void populateMap(BTNode root, Map<Integer, List<BTNode>> map, int level) {

        if (root == null)
            return;

        // add root
        if (map.get(level) == null) {
            map.put(level, new LinkedList<BTNode>());
        }
        map.get(level).add(root);

        populateMap(root.left, map, level - 1);
        populateMap(root.right, map, level + 1);
    }

}

package interviewquestions;

import java.util.LinkedList;
import java.util.Queue;

import utils.BTNode;

/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700248
 * http://algorithms.tutorialhorizon.com/level-order-traversal-print-each-level-in-separate-line/
 * http://algorithms.tutorialhorizon.com/in-a-binary-tree-create-linked-lists-of-all-the-nodes-at-each-depth/
 * 
 * @author ntk4
 *
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.left.left = new BTNode(4);
        root.left.left.right = new BTNode(8);
        root.left.right = new BTNode(5);
        root.right = new BTNode(3);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);

        levelOrder(root);
    }

    private static void levelOrder(BTNode root) {
        if (root == null)
            return;

        Queue<BTNode> queue = new LinkedList<BTNode>();

        queue.add(root);
        int levelNodes = 1;

        while (!queue.isEmpty()) {
            levelNodes = queue.size();

            while (levelNodes-- > 0) {
                BTNode node = queue.poll();
                System.out.print(node.value + " ");

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            System.out.print("$ ");

        }

    }

}

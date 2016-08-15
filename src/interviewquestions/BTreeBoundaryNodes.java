package interviewquestions;

import java.util.Scanner;

import utils.BTNode;
import utils.BTreeSerializer;

/**
 * See the question on:
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-275-offcampus-sde-i-experienced/
 * and other solutions on: 
 * http://articles.leetcode.com/print-edge-nodes-boundary-of-binary/
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 
 * @author ntk4
 *
 */
public class BTreeBoundaryNodes {

    private static final Integer[] tree = { 30, 10, 20, 50, 30, 45, 35 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BTNode root = BTreeSerializer.deserializeTree(tree);

        printBoundaryNodes(root);

        in.close();

    }

    private static void printBoundaryNodes(BTNode root) {

        System.out.print(root.value + " ");
        
        printLeftBranch(root);

        printLeafNodes(root);

        printRightBranch(root);
    }

    private static void printLeftBranch(BTNode root) {
        BTNode current = root.left;
        while (current.left != null) {
            System.out.print(current.value + " ");
            current = current.left;
        }
    }

    private static void printLeafNodes(BTNode root) {
        if (root.left != null && root.right != null) {
            printLeafNodes(root.left);
            printLeafNodes(root.right);
        } else
            System.out.print(root.value + " ");
    }

    private static void printRightBranch(BTNode root) {
        if (root.right != null) {
            printRightBranch(root.right);
            if (root.right.right != null)
                System.out.print(root.right.value + " ");
        }
        
    }

}

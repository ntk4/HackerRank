package interviewquestions;

import utils.BTNode;

public class FindPairWithGivenSumInBalancedBST {

    public static void main(String[] args) {
        BTNode root = new BTNode(15);
        root.left = new BTNode(10);
        root.left.left = new BTNode(8);
        root.left.right = new BTNode(12);
        root.right = new BTNode(20);
        root.right.left = new BTNode(16);
        root.right.right = new BTNode(25);
        
        
        int sum = 32;
        
        System.out.println(findSumInTree(root, sum));
    }

    private static int findSumInTree(BTNode root, int sum) {
        
        if (root == null)
            return 0;
        
        findSumInTree(root.left, sum);
        
        findSumInTree(root.right, sum);
        
        return 0;
    }

}

package interviewquestions;

import utils.BTNode;

/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700236
 * 
 * @author ntk4
 *
 */
public class LowestCommonAncestorInBST {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.left.left = new BTNode(4);
        root.left.left.right = new BTNode(8);
        root.left.right = new BTNode(5);
        root.right = new BTNode(3);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);

        System.out.println(new LowestCommonAncestorInBST().lca(root, root.left.left.right, root.right.left).value); // should be root
        System.out.println(new LowestCommonAncestorInBST().lca(root, root.left.right, root.left.left).value); // should be root.left
        System.out.println(new LowestCommonAncestorInBST().lca(root, root.right, root.right.right).value); // should be root.right
    }

    private BTNode lca(BTNode root, BTNode node1, BTNode node2) {
        if (node1 == root || node2 == root)
            return root;
        
        boolean isNode1Left = isUnder(root.left, node1);
        boolean isNode2Left = isUnder(root.left, node2);
        
        if (isNode1Left != isNode2Left)
            return root;
        else if (isNode1Left && isNode2Left)
            return lca(root.left, node1, node2);
        else return lca(root.right, node1, node2);
        
    }

    private boolean isUnder(BTNode parent, BTNode node1) {
        if (parent == null || node1 == null)
            return false;
        if (parent == node1)
            return true;
        
        if (parent.left == node1 || parent.right == node1)
            return true;
        boolean isUnderLeft = isUnder(parent.left, node1);
        boolean isUnderRight = isUnder(parent.right, node1);
        
        return isUnderLeft || isUnderRight;
    }

}

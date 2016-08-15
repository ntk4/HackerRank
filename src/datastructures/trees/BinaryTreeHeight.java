package datastructures.trees;

public class BinaryTreeHeight {
    /* you only have to complete the function given below.  
    Node is defined as  

    */
    class Node {
        int data;
        Node left;
        Node right;
    }


    int height(Node root)
    {
        return calculateHeight(root, 0); 
    }
    
    int calculateHeight(Node node, int currentHeight) {
        int heightLeft = currentHeight;
        if (node.left != null) 
            heightLeft = calculateHeight(node.left, currentHeight + 1);
        
        int heightRight = currentHeight;
        if (node.right != null) 
            heightRight = calculateHeight(node.right, currentHeight + 1);
        
        return Math.max(heightLeft, heightRight);
    }
}

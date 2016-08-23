package interviewquestions;

import java.util.LinkedList;
import java.util.List;

public class UniqueRowsInBooleanMatrix {

    static class Node {
        public boolean value;

        public List<Node> children;
        
        public boolean fresh;

        public Node() {
            children = new LinkedList<Node>();
        }
    }

    public static void main(String[] args) {

        boolean[][] matrix = new boolean[][] { { true, true, false, true }, { true, false, true, true }, { true, true, false, true } };

        Node root = populateTrie(matrix);
    }

    private static Node populateTrie(boolean[][] matrix) {
        Node root = new Node(), currentNode = null;

        if (matrix.length == 0)
            return root;

        for (int i = 0; i < matrix.length; i++) {

            currentNode = root;
            
            for (int j = 0; j < matrix.length; j++) {
                Node newNode = placeNodeUnder(currentNode, matrix[i][j]);
                if (newNode == null) {
                    System.out.println(String.format("Error! current node is null for i=%d, j=%d", i, j));
                    return root;
                } else if (newNode.fresh && j == matrix.length - 1) {
                    printRow(matrix[i]);
                }
                currentNode = newNode;   
            }
        }

        return root;
    }

    private static void printRow(boolean[] bs) {
        for (boolean value : bs) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static Node placeNodeUnder(Node currentNode, boolean value) {

        if (currentNode == null)
            return null;

        for (Node child : currentNode.children) {
            if (child.value == value) {
                child.fresh = false;
                return child;
            }
        }
        
        Node newNode = new Node();
        newNode.value = value;
        currentNode.children.add(newNode);
        newNode.fresh = true;
        return newNode;
    }

}

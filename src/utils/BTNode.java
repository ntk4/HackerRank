package utils;

public class BTNode {
    
    public BTNode(int value, BTNode left, BTNode right) {
        super();
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public BTNode(int value) {
        super();
        this.value = value;
    }
    
    public int value;
    
    public BTNode left;
    public BTNode right;
    
    
}

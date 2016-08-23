package interviewquestions;

/**
 * http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
 * 
 * @author ntk4
 *
 */
public class ConvertSortedListToBST {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Definition for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    ListNode current = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        
        ConvertSortedListToBST converter = new ConvertSortedListToBST();
        converter.current = head;
        TreeNode root = converter.convertLLToBST(head);

        converter.preOrderPrint(root);
    }

    private void preOrderPrint(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    private TreeNode convertLLToBST(ListNode head) {
        int length = 0;
        ListNode runner = head;
        while (runner != null) {
            length++;
            runner = runner.next;
        }

        return convertLLToBstHelper(head, 0, length - 1);
    }

    private TreeNode convertLLToBstHelper(ListNode head, int start, int end) {
        if (start > end)
            return null;
        
        int mid = (start + end) / 2;
        
        TreeNode left = convertLLToBstHelper(current, start, mid - 1);
        TreeNode parent = new TreeNode(current.val);
        current = current.next;
        TreeNode right = convertLLToBstHelper(current, mid + 1, end);
        
        parent.left = left;
        parent.right = right;
        
        return parent;
    }

}

package datastructures.linkedlist;
public class GetNodeValue {

    static class Node {
        int data;
        Node next;
    }
    
    public static void main(String[] args) {
        Node headA = new Node();
        headA.data = 1;
        Node headA2 = new Node();
        headA2.data = 3;
        Node headA3 = new Node();
        headA3.data = 5;
        Node headA4 = new Node();
        headA4.data = 6;
        headA.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        
        
        int value = GetNode(headA, 2);
        System.out.println (value);
    }
    
    static int GetNode(Node head,int n) {
        Node runner = head;
        while (n-- > 0 && runner != null) 
            runner = runner.next;
        
        
        Node runner2 = head;
        while (runner != null && runner.next != null) {
            runner = runner.next;
            runner2 = runner2.next;
        }
        
        return runner2.data;
            
    }

}

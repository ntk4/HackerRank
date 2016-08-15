package datastructures.linkedlist;
public class LinkedListRemoveDuplicates {

    static class Node {
        int data;
        Node next;
    }

    /*
    Merge two linked lists 
    head pointer input could be NULL as well for empty list
    Node is defined as 
    class Node {
       int data;
       Node next;
    }
  */
    
    public static void main(String[] args) {
        Node headA = new Node();
        headA.data = 1;
        Node headA2 = new Node();
        headA2.data = 3;
        Node headA3 = new Node();
        headA3.data = 5;
        Node headA4 = new Node();
        headA4.data = 6;
        Node headA5 = new Node();
        headA5.data = 6;
        headA.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headA4.next = headA5;
        
        
        Node head = RemoveDuplicates(headA);
        while (head != null) {
            System.out.print (head.data);
            head = head.next;
        }
    }
    
    static Node RemoveDuplicates(Node head) {
        
        Node runner = head;
        while (runner != null) {
            if (runner.next != null && runner.data == runner.next.data)
                runner.next = runner.next.next;
            else 
                runner = runner.next;
        }
        
        return head;
    }

}

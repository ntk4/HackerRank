package datastructures.linkedlist;
public class LinkedListReversePrint {

    static class Node {
        int data;
        Node next;
    }

    
    void ReversePrint(Node head) {
        // This is a "method-only" submission. 
        // You only need to complete this method. 
          if (head == null) return;
          else if (head.next != null) ReversePrint(head.next);
          System.out.println(head.data);
      }
}

package datastructures.linkedlist;
public class LinkedListMergeSortedLists2 {

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
        headA.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        
        Node headB = new Node();
        headB.data = 2;
        Node headB2 = new Node();
        headB2.data = 4;
        Node headB3 = new Node();
        headB3.data = 7;
        headB.next = headB2;
        headB2.next = headB3;
        
        Node merged = MergeLists(headA, headB);
        while (merged != null) {
            System.out.print (merged.data + " ");
            merged = merged.next;
        }
    }

    /**
     * recursive solution
     * @param headA
     * @param headB
     * @return
     */
  static Node MergeLists(Node headA, Node headB) {
       // This is a "method-only" submission. 
       // You only need to complete this method 
      if (headA == null && headB == null) return null;
      else if (headA != null && headB == null) return headA;
      else if (headA == null && headB != null) return headB;
      else {
          Node head = null;
          if (headA.data <= headB.data) {
              head = new Node();
              head.data = headA.data;
              head.next = MergeLists(headA.next, headB);
          } else {
              head = new Node();
              head.data = headB.data;              
              head.next = MergeLists(headA, headB.next);
          }
          return head;
      }
      

  }

}

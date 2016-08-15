package datastructures.linkedlist;
public class LinkedListMergeSortedLists {

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
     * Iterative solution
     * @param headA
     * @param headB
     * @return
     */
  static Node MergeLists(Node headA, Node headB) {
       // This is a "method-only" submission. 
       // You only need to complete this method 
      Node newHead = null, runner = null;
      
      while (headA != null && headB != null) {
          if (headA.data < headB.data) {
              
              if (newHead == null) {
                  newHead = headA;
                  runner = newHead;
              }
              else {
                  runner.next = headA;
                  runner = runner.next;
              }
              
              headA = headA.next;
              
          } else if (headA.data >= headB.data) {
              
              if (newHead == null) {
                  newHead = headB;
                  runner = newHead;
              }
              else {
                  runner.next = headB;
                  runner = runner.next;
              }
              
              headB = headB.next;
          }
      }
      
      if (headA != null) {
          if (newHead != null) runner.next = headA;
          else newHead = headA;
      }
      if (headB != null) {
          if (newHead != null) runner.next = headB;
          else newHead = headB;
      }
          
      return newHead;

  }

}

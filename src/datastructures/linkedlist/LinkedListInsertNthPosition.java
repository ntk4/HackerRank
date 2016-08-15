package datastructures.linkedlist;
public class LinkedListInsertNthPosition {

    static class Node {
        int data;
        Node next;
    }

    static Node Delete(Node head, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        if (position > 1) Delete(head.next, position -1);
        else if (position == 0) head = head.next;
        else head.next = head.next.next;
        return head;

    }
}

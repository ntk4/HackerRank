package datastructures.linkedlist;
import java.util.Scanner;

public class LinkedListDeleteNthPosition {

    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node head = null;

        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            int position = scanner.nextInt();

            head = InsertNth(head, data, position);
        }
        
        Node runner = head;
        while (runner != null) {
            System.out.print(runner.data);
            runner = runner.next;
        }

        scanner.close();
    }

    static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node before = head;
        for (int i = 0; i < position - 1; i++) {
            if (before.next != null)
                before = before.next;
        }

        // System.out.println(before.data);
        Node newNode = new Node();
        newNode.data = data;
        if (before == null)
            return newNode;
        else {
            newNode.next = before.next;
            before.next = newNode;
            return head;
        }

    }
}

package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Definition for a binary tree node. public class BTNode { int val; BTNode left; BTNode right; BTNode(int x) { val = x; } }
 */
public class Codec {

    private static final int MARKER = -1;

    // Encodes a tree to a single string.
    public String serialize(BTNode root) {
        if (root == null)
            return null;

        List<Integer> list = new LinkedList<Integer>();

        serializeHelper(root, list);

        StringBuilder sb = new StringBuilder();
        for (Integer element : list) {
            if (element == null)
                sb.append(',');
            else
                sb.append(element).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private void serializeHelper(BTNode root, List<Integer> list) {
        if (root == null) {
            list.add(MARKER);
            return;
        }

        list.add(root.value);
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
    }

    // Decodes your encoded data to tree.
    public BTNode deserialize(String data) {

        Scanner in = new Scanner(data);
        in.useDelimiter(",");
        Queue<Integer> queue = new LinkedList<Integer>();
        // Scanner in = new Scanner(new ArrayInputStream(data.getChars());
        while (in.hasNext()) {
            String s = in.next();
            if ("".equals(s))
                queue.add(null);
            else
                queue.add(Integer.parseInt(s));
        }
        in.close();

        return deserializeHelper(queue);
    }

    private BTNode deserializeHelper(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty() || queue.peek() == MARKER) {
            queue.poll();
            return null;
        }

        BTNode newNode = new BTNode(queue.poll());
        newNode.left = deserializeHelper(queue);
        newNode.right = deserializeHelper(queue);

        return newNode;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node2a = new BTNode(5);
        BTNode node3 = new BTNode(3);
        BTNode node3a = new BTNode(6);
        node2.left = node2a;
        node2.right = node3a;
        root.left = node2;
        root.right = node3;

        Codec codec = new Codec();
        // print original structure
        codec.inOrderPrint(root);
        System.out.println();

        // serialize & deserialize
        BTNode result = codec.deserialize(codec.serialize(root));

        // print processed structure
        codec.inOrderPrint(result);
        System.out.println();
    }

    private void inOrderPrint(BTNode node) {
        if (node == null)
            return;

        inOrderPrint(node.left);
        System.out.print(node.value + " ");
        inOrderPrint(node.right);
    }
}

package page.leetcode.three;

import java.util.HashMap;
import java.util.Map;

public class OneHundredAndEight {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();

        Node node = head;
        Node copyNodeFirst = new Node(head.val);
        Node copyNode = copyNodeFirst;
        nodeMap.put(head, copyNodeFirst);
        while (node.next != null) {
            copyNode.next = new Node(node.next.val);
            node = node.next;
            copyNode = copyNode.next;
            nodeMap.put(node, copyNode);
        }
        node = head;
        copyNode = copyNodeFirst;
        while (node != null) {
            copyNode.random = nodeMap.get(node.random);
            node = node.next;
            copyNode = copyNode.next;
        }
        return copyNodeFirst;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }
}

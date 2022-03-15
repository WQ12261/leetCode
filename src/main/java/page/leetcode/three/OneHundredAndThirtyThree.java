package page.leetcode.three;


import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class OneHundredAndThirtyThree {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        dfsNodeClone(node, map);
        return map.get(node);
    }

    private Node dfsNodeClone(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighbor = node.neighbors.get(i);
            Node cloneNeighbor = dfsNodeClone(neighbor, map);
            cloneNode.neighbors.add(cloneNeighbor);
        }
        return cloneNode;
    }

    /**
     * 待改进
     * @param node
     * @return
     */
    public Node bfsCloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> nodeCloneMap = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node nodeNotCloned = queue.poll();
            Node clone = new Node(nodeNotCloned.val);
            nodeCloneMap.put(nodeNotCloned, clone);
            for (Node neighbor : nodeNotCloned.neighbors) {
                if (!nodeCloneMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        Set<Node> nodes = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Node clone = nodeCloneMap.get(poll);
            nodes.add(poll);
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(nodeCloneMap.get(neighbor));
                if (!nodes.contains(neighbor)){
                    queue.add(neighbor);
                }
            }
        }
        return nodeCloneMap.get(node);
    }

    public static void main(String[] args) {
        System.out.println(ag(1)|isOk());
        Map<String,String> map  = new HashMap<>();
        map.put("a", "a");
    }
    public static boolean ag(int t){
        System.out.println("dsaf");
        return t%2 ==0;
    }

    public static boolean isOk(){
        long l = System.currentTimeMillis();
        System.out.println(l);
        return l%2 == 0;
    }
}

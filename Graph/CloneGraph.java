package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @leetcode: 133. Clone Graph
 */
public class CloneGraph {
    public static void main(String[] args) {}

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // Queue to save nodes from current graph
        // which are used to create new ones.
        Queue<Node> q = new LinkedList<>();
        // Map to find if a node has been copied.
        Map<Node, Node> map = new HashMap<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (!map.containsKey(curr)) {
                // Saved copied node to map
                map.put(curr, new Node(curr.val));
            }
            for (Node n : curr.neighbors) {
                // A new node is found in current graph
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    static class Node {
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
}
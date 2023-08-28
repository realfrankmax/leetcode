package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 428. Serialize and Deserialize N-ary Tree
 */
public class SerializeNaryTree {
    public static void main(String[] args) {}
    
    // root.val_size + nodes
    static class Codec {
        static char EMPTY = '#';
        static char DELIMITER = ',';
        static String UNDERSCORE = "_";
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder builder = new StringBuilder();
            if (root == null) {
                builder.append(EMPTY).append(DELIMITER);
                return builder.toString();
            }
            builder.append(root.val).append(UNDERSCORE);
            builder.append(root.children.size()).append(DELIMITER);
            for (Node child : root.children) {
                builder.append(serialize(child));
            }
            return builder.toString();
        }
        
        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            int[] p = new int[1];
            return helper(data, p);
        }
        private Node helper(String data, int[] p) {
            if (p[0] >= data.length()) {
                return null;
            }
            if (data.charAt(p[0]) == EMPTY) {
                p[0] += 2;
                return null;
            }
            for (int i = p[0]; i < data.length(); i++) {
                if (data.charAt(i) == DELIMITER) {
                    String[] rootFact = data.substring(p[0], i).split(UNDERSCORE);
                    int rootVal = Integer.parseInt(rootFact[0]);
                    int childrenSize = Integer.parseInt(rootFact[1]);
                    Node root = new Node(rootVal, new ArrayList<>());
                    p[0] = i+1;
                    while (childrenSize-- != 0) {
                        root.children.add(helper(data, p));
                    }
                    return root;
                }
            }
            return null;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
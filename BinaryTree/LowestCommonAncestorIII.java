package BinaryTree;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode: 1650. Lowest Common Ancestor of a Binary Tree III
 */
public class LowestCommonAncestorIII {
    public static void main(String[] args) {}

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> bottomUp = new HashSet<>();
        while (p != null || q != null) {
            if (p != null) {
                if (!bottomUp.add(p)) {
                    return p;
                }
                p = p.parent;
            }
            if (q != null) {
                if (!bottomUp.add(q)) {
                    return q;
                }
                q = q.parent;
            }
        }
        return null;
    }

    // Going up until the root and then switch to another node
    // tmp1 will go from p to common ancestor, root, (back to q) and to common ancestor
    // tmp2 will go from q to common ancestor, root, (back to p) and to common ancestor
    // Their travel distances are the same when meeting at common ancestor
    public Node lowestCommonAncestor_1(Node p, Node q) {
        Node tmp1 = p;
        Node tmp2 = q;
        while(tmp1 != tmp2) {
            tmp1 = tmp1.parent == null ? q : tmp1.parent;
            tmp2 = tmp2.parent == null ? p : tmp2.parent;
        }
        return tmp1;
    }
}
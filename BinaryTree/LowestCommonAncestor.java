package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> levels = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        levels.add(root);
        parents.put(root, null);
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode curr = levels.remove();
            if (curr.left != null) {
                levels.add(curr.left);
                parents.put(curr.left, curr);
            }
            if (curr.right != null) {
                levels.add(curr.right);
                parents.put(curr.right, curr);
            }
        }
        Set<TreeNode> bottomUp = new HashSet<>();
        while (p != null) {
            bottomUp.add(p);
            p = parents.get(p);
        }
        while (q != null) {
            if (bottomUp.contains(q)) {
                return q;
            }
            q = parents.get(q);
        }
        return null;
    }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null) {
    //         return null;
    //     }
    //     if (root.val == p.val || root.val == q.val) {
    //         return root;
    //     }
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     if (left != null && right != null) {
    //         // Means the two nodes are on separated between two sides.
    //         return root;
    //     } else if (left != null) {
    //         return left;
    //     } else {
    //         return right;
    //     }
    // }
}
package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @leetcode: 863. All Nodes Distance K in Binary Tree
 */
public class DistanceK {
    public static void main(String[] args) {}

    private Map<TreeNode, TreeNode> parents;

    // BFS
    // Build a map from node to its parent
    // So from a node, we could check its two children and one parent which has distance 1.
    // Use hashset to avoid same node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null || k < 0) {
            return res;
        }
        this.parents = new HashMap<>();
        buildGraph(root, null);

        Queue<TreeNode> nodes = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        nodes.add(target);
        visited.add(target);

        while (!nodes.isEmpty()) {
            if (k == 0) {
                while (!nodes.isEmpty()) {
                    res.add(nodes.remove().val);
                }
                return res;
            }
            k--;
            int size = nodes.size();
            while (size-- != 0) {
                TreeNode curr = nodes.remove();
                if (curr.left != null && visited.add(curr.left)) {
                    nodes.add(curr.left);
                }
                if (curr.right != null && visited.add(curr.right)) {
                    nodes.add(curr.right);
                }
                TreeNode p = this.parents.getOrDefault(curr, null);
                if (p != null && visited.add(p)) {
                    nodes.add(p);
                }
            }
        }
        return res;
    }

    private void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        this.parents.put(root, parent);
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}
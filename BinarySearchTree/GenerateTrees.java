package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 95. Unique Binary Search Trees II
 */
public class GenerateTrees {
    public static void main(String[] args) {}
    // Time: around O(2^n)
    // Map<String, List<TreeNode>> cache;
    public List<TreeNode> generateTrees(int n) {
        // cache = new HashMap<>();
        return helper(1, n);
    }
    private List<TreeNode> helper (int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        // if (this.cache.containsKey(start+","+end)) {
        //     return this.cache.get(start+","+end);
        // }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = helper(start, i-1);
            List<TreeNode> rightSubtrees = helper(i+1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        // this.cache.put(start+","+end, res);
        return res;
    }
}
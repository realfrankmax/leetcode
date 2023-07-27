package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 437. Path Sum III
 */
public class PathSumIII {
    public static void main(String[] args) {}

    private int count;
    private Map<Long, Integer> prefixSum;

    public int pathSum(TreeNode root, int targetSum) {
        prefixSum = new HashMap<>();
        // when path sum is zero, it will count as one result
        prefixSum.put((long)0, 1);
        helper(root, 0, targetSum);
        return count;
    }
    private void helper(TreeNode root, long pathSum, int targetSum) {
        if (root == null) {
            return ;
        }
        pathSum += root.val;
        this.count += this.prefixSum.getOrDefault(pathSum-targetSum, 0);
        this.prefixSum.put(pathSum, this.prefixSum.getOrDefault(pathSum, 0)+1);
        helper(root.left, pathSum, targetSum);
        helper(root.right, pathSum, targetSum);
        // The update from left subtree should not affect the calculation in right subtree.
        this.prefixSum.put(pathSum, this.prefixSum.getOrDefault(pathSum, 0)-1);
    }
}
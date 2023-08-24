package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @leetcode: 113. Path Sum II
 */
public class PathSum {
    public static void main(String[] args) {}

    private List<List<Integer>> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.path = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return this.path;
    }

    private void helper(TreeNode root, int target, List<Integer> currPath) {
        if (root == null) {
            return ;
        }
        currPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                this.path.add(new ArrayList<>(currPath));
            }
        }
        helper(root.left, target - root.val, currPath);
        helper(root.right, target - root.val, currPath);
        currPath.remove(currPath.size()-1);
    }
}

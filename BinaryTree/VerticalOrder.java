package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @leetcode: 314. Binary Tree Vertical Order Traversal
 */
public class VerticalOrder {
    public static void main(String[] args) {}

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> pos = new LinkedList<>();
        q.add(root);
        pos.add(0);
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            int currPos = pos.remove();
            min = Math.min(min, currPos);
            max = Math.max(max, currPos);
            map.computeIfAbsent(currPos, x -> new ArrayList<>());
            map.get(currPos).add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
                pos.add(currPos-1);
            }
            if (curr.right != null) {
                q.add(curr.right);
                pos.add(currPos+1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

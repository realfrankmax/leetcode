package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @leetcode: 987. Vertical Order Traversal of a Binary Tree
 */
public class VerticalOrderII {
    public static void main(String[] args) {}

    // Time O(N) with the sort on nodes with same pos on each level could be ignored.
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> buffer = new LinkedList<>();
        buffer.add(root);
        Queue<Integer> pos = new LinkedList<>();
        pos.add(0);
        int min = 0;
        int max = 0;
        Map<Integer, List<Integer>> byVertical = new HashMap<>();
        while (!buffer.isEmpty()) {
            Map<Integer, List<Integer>> currLevel = new HashMap<>();
            int size = buffer.size();
            while (size-- != 0) {
                TreeNode currNode = buffer.remove();
                int currPos = pos.remove();
                min = Math.min(min, currPos);
                max = Math.max(max, currPos);
                currLevel.computeIfAbsent(currPos, x -> new ArrayList<>());
                currLevel.get(currPos).add(currNode.val);
                if (currNode.left != null) {
                    buffer.add(currNode.left);
                    pos.add(currPos-1);
                }
                if (currNode.right != null) {
                    buffer.add(currNode.right);
                    pos.add(currPos+1);
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : currLevel.entrySet()) {
                byVertical.computeIfAbsent(entry.getKey(), x -> new ArrayList<>());
                Collections.sort(entry.getValue());
                byVertical.get(entry.getKey()).addAll(entry.getValue());
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(byVertical.get(i));
        }
        return res;
    }
}
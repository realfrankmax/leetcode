package HighFrequency;

/**
 * @leetcode: 1123. Lowest Common Ancestor of Deepest Leaves
 */
public class LcaDeepestLeaves {
    public static void main(String[] args) {}

    // Time O(n^2) but if saving a node-height map, it could be O(n)
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return root;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == rightHeight) {
            return root;
        }
        if (leftHeight > rightHeight) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    private int height (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    /**
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return null;
        }
        q.add(root);
        parent.put(root, null);
        while(!q.isEmpty()) {
            int size = q.size();
            Set<TreeNode> currentLayer = new HashSet<>();
            while (size-- != 0) {
                TreeNode curr = q.remove();
                currentLayer.add(curr);
                if (curr.left != null) {
                    q.add(curr.left);
                    parent.put(curr.left, curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    parent.put(curr.right, curr);
                }
            }
            if (q.isEmpty()) {
                while (currentLayer.size() != 1) {
                    Set<TreeNode> upLayer = new HashSet<>();
                    for (TreeNode n : currentLayer) {
                        upLayer.add(parent.get(n));
                    }
                    currentLayer = upLayer;
                }
                return currentLayer.iterator().next();
                // for (TreeNode n : currentLayer) {
                //     return n;
                // }
            }
        }
        return null;
    }
    */
}
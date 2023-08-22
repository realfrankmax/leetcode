package DynamicProgramming;

/**
 * @leetcode: 337. House Robber III
 */
public class HouseRobIII {
    public static void main(String[] args) {}

    public int rob(TreeNode root) {
        int[] res = robNodes(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robNodes(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] robLeft = robNodes(root.left);
        int[] robRight = robNodes(root.right);
        int[] res = new int[2];
        res[0] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        res[1] = root.val + robLeft[0] + robRight[0];
        return res;
    }
}
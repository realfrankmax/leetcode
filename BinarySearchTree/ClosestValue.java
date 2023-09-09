package BinarySearchTree;

/**
 * @leetcode: 270. Closest Binary Search Tree Value
 */
public class ClosestValue {
    public static void main(String[] args) {}

    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int res = root.val;
        while(root != null){
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            } else if (Math.abs(root.val - target) == Math.abs(res - target)) {
                res = Math.min(root.val, res);
            }
            if(root.val == target){
                return root.val;
            }else if(root.val > target){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
}

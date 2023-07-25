package HighFrequency;

/**
 * @leetcode: 129. Sum Root to Leaf Numbers
 */
public class SumNumbers {
    public static void main(String[] args) {}

    private int sum;

    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        sumNumbersWithBase(root, 0);
        return this.sum;    
    }
    private void sumNumbersWithBase(TreeNode root, int base) {
        if (root == null) {
            return ;
        }
        int newBase = base*10 + root.val;
        if (root.left == null && root.right == null) {
            this.sum += newBase;
            return ;
        }
        sumNumbersWithBase(root.left, newBase);
        sumNumbersWithBase(root.right, newBase);
    }
}
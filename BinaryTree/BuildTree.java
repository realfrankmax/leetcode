package BinaryTree;

/**
 * @leetcode: Construct Binary Tree from Preorder and Inorder Traversal
 */
public class BuildTree {
    public static void main(String[] args) {}

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;    
        this.inorder = inorder;
        return build(0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode build(int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(this.preorder[pStart]);
        for (int i = iStart; i <= iEnd; i++) {
            if (this.inorder[i] == root.val) {
                int rootIdx = i;
                int leftSize = rootIdx - iStart;
                root.left= build(pStart+1, pStart+leftSize, iStart, rootIdx-1);
                root.right = build(pStart+leftSize+1, pEnd, rootIdx+1, iEnd);
                return root;
            }
        }
        return null;
    }
}
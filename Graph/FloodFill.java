package Graph;

/**
 * @leetcode: Flood Fill
 */
public class FloodFill {
    public static void main(String[] args) {}

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        helper(image, sr, sc, image[sr][sc], color);
        return image;
    }
    private void helper (int[][] image, int sr, int sc, int ori, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != ori) {
            return ;
        }
        image[sr][sc] = color;
        helper(image, sr+1, sc, ori, color);
        helper(image, sr, sc+1, ori, color);
        helper(image, sr-1, sc, ori, color);
        helper(image, sr, sc-1, ori, color);
        return;
    }
}   
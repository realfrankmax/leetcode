package Array;

/**
 * @leetcode: 84. Largest Rectangle in Histogram
 */
public class LargestRectangleArea {
    public static void main(String[] args) {}

    public int largestRectangleArea(int[] heights) {
        // for a given height, the largest width with its height, 
        // is to figure out positions on left and right that equals to or greater than itself.
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int pointer = i-1;
            while (pointer >= 0 && heights[pointer] >= heights[i]) {
                // reuse result from previous checks
                // skip instead of using p--
                pointer = left[pointer];
            }
            left[i] = pointer;
        }

        for (int i = heights.length-1; i >= 0 ; i--) {
            int pointer = i+1;
            while (pointer < heights.length && heights[pointer] >= heights[i]) {
                pointer = right[pointer];
            }
            right[i] = pointer;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // left: first index that lower than curr height on left side
            // right: first index that lower than curr height on right side
            // So it has to be right - left - 1 instead of right - left + 1.
            max = Math.max(max, heights[i] * (right[i]-left[i]-1));
        }
        return max;
    }
}

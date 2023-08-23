package Array;

/**
 * @leetcode: 11. Container With Most Water

 */
public class MaxArea {
    public static void main(String[] args) {}

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            // Move pointer with smaller height.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
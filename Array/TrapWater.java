package Array;

/**
 * @leetcode: 42. Trapping Rain Water
 */
public class TrapWater {
    public static void main(String[] args) {}

    /**  
     * The water is trapped inside a V shape, the volumn depends on the shorter side.
     * Comparing two boundries simlifies the logic because it doesn't matter the values in between
     * It is true that any areas NEXT to boundries and SHORTER than the SMALLER boundry will be
     * filled with water.
     */
    public int trap(int[] height) {
        int vol = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            if (height[left] < height[right]) {
                int i = left;
                while ((i < right) && height[i] <= height[left]) {
                    vol += height[left]-height[i];
                    i++;
                }
                left = i;
            } else {
                int i = right;
                while ((left < i) && height[i] <= height[right]) {
                    vol += height[right] - height[i];
                    i--;
                }
                right = i;
            }
        }
        return vol;
    }
}
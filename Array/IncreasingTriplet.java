package Array;

/**
 * @leetcode: 334. Increasing Triplet Subsequence
 */
public class IncreasingTriplet {
    public static void main(String[] args) {}

    // Similar to 300. Longest Increasing Subsequence
    public boolean increasingTriplet(int[] nums) {
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= p1) {
                p1 = n;
            } else if (n <= p2) {
                p2 = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
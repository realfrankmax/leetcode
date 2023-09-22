package Recursion;

/**
 * @leetcode: 486. Predict the Winner
 */
public class PredictTheWinner {
    public static void main(String[] args) {}

    Integer[][] score;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        score = new Integer[n][n];
        return getDifference(nums, 0, n-1) >= 0;
    }
    private int getDifference(int[] nums, int start, int end) {
        if (score[start][end] == null) {
            if (start == end) {
                score[start][end] = nums[start];
            } else {
                score[start][end] = Math.max(nums[start] - getDifference(nums, start+1, end), nums[end] - getDifference(nums, start, end-1));
            }
        }
        return score[start][end];
    }
}
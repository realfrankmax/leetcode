package DynamicProgramming;

/**
 * @leetcode: 70. Climbing Stairs
 */
public class ClimbStairs {
    public static void main(String[] args) {}

    /**
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= n; i++) {
            count[i] = count[i-1] + count[i-2];
        }
        return count[n];
    }
     */
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        int curr = 0;
        int prev1 = 2;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
package Math;

/**
 * @leetcode: 779. K-th Symbol in Grammar
 */
public class KthGrammar {
    public static void main(String[] args) {}

    // The result is related to k and its parent
    public int kthGrammar(int n, int k) {
        if (k > Math.pow(2, n-1)) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        // Find out parent 1 or 0
        int parent = kthGrammar(n-1, (k+1) / 2);
        // exclusive OR with reversed last bit of K
        /**
         * 
         *           0
         *      0          1
         *   0    1   1       0
         * 0  1 1  0 1  0    0  1
         */
        return parent ^ (~k&1);
    }
    /**
    public int kthGrammar(int n, int k) {
        if (k > Math.pow(2, n-1)) {
            return -1;
        }
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        while (n-- != 0) {
            if (n == 0) {
                return nums.get(k-1);
            }
            List<Integer> next = new ArrayList<>();
            for (int num : nums) {
                if (num == 0) {
                    next.add(0);
                    next.add(1);
                } else {
                    next.add(1);
                    next.add(0);
                }
            }
            nums = next;
        }
        return -1;
    }
    */
}
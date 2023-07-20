package Math;

import java.util.Random;

/**
 * @leetcode: Random Pick with Weight
 */
public class PickIndex {
    public static void main(String[] args) {}

    class Solution {
        private int[] prefixSum;
        public Solution(int[] w) {
            prefixSum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                if (i == 0) {
                    prefixSum[0] = w[0];
                } else {
                    prefixSum[i] = w[i]+prefixSum[i-1];
                }
            }
        }
        
        public int pickIndex() {
            Random rand = new Random();
            // nextInt returns [0, i), it needs to +1
            int val = rand.nextInt(prefixSum[prefixSum.length-1])+1;
            int left = 0;
            int right = prefixSum.length-1;
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (prefixSum[mid] == val) {
                    return mid;
                } else if (prefixSum[mid] > val) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            return left;
        }
    }

}

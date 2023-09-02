package BinarySearch;

/**
 * @leetcode: 1011. Capacity To Ship Packages Within D Days
 */
public class ShipWithinDays {
    public static void main(String[] args) {}
    /**
     * Similar to 
     * 1552. Magnetic Force Between Two Balls
     * 410. Split Array Largest Sum
     */
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int w : weights) {
            max += w;
            min = Math.min(w, min);
        }
        int res = 0;
        while (min <= max) {
            int mid = min + (max-min)/2;
            if (canShip(weights, mid, days)) {
                res = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return res;
    }
    private boolean canShip(int[] weights, int capacity, int days) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > capacity) {
                days--;
                i--;
                sum = 0;
            }
            if (days == 0) {
                return false;
            }
        }
        return true;
    }
}
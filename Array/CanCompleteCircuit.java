package Array;

/**
 * @leetcode: 134. Gas Station
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {}

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int local = 0;
        int total = 0;
        int pos = 0;
        // If it can complete, total sum of gas must be greater than sum of cost.
        // As long as there is negative sum, all the previous positions couldn't be a start point.
        // As long as the local sum is positive, it could be the start.
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            local += gas[i] - cost[i];
            if (local < 0) {
                local = 0;
                pos = i+1;
            }
        }
        return total >= 0 ? pos : -1;
    }
}
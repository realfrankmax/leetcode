package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @leetcode: 403. Frog Jump
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump fj = new FrogJump();
        int[] input = new int[10000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        fj.canCross(input);
    }

    // Time O(n^2): assume stones like [0, 1, 2, 3, 4, 5]
    // From the test, the nextStep size is much smaller than n
    // the run time could be n*logn
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> nextStep = new HashMap<>();
        // Map<Integer, List<Integer>> nextStep = new HashMap<>();
        for (int s : stones) {
            nextStep.put(s, new HashSet<>());            
            // nextStep.put(s, new ArrayList<>());

        }
        nextStep.get(stones[0]).add(0);
        for (int i = 0; i < stones.length-1; i++) {
            // if (i == stones.length-2) {
                // System.out.println(nextStep.get(stones[i]).size());
            // }
            for (int step : nextStep.get(stones[i])) {
                for (int k = step-1; k <= step+1; k++) {
                    if (k > 0 && nextStep.containsKey(stones[i]+k)) {
                        nextStep.get(stones[i]+k).add(k);
                    }
                }
            }
        }
        return !nextStep.get(stones[stones.length-1]).isEmpty();
    }
}
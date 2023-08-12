package Recursion;

import java.util.List;

/**
 * @leetcode: 339. Nested List Weight Sum
 */
public class DepthSum {
    public static void main(String[] args) {}

    private interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return calculate(nestedList, 1);
    }
    private int calculate(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level;
            } else {
                sum += calculate(ni.getList(), level+1);
            }
        }
        return sum;
    }
}
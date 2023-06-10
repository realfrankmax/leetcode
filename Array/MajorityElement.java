package Array;

/**
 * @leetcode: Majority Element
 */
public class MajorityElement {
    public static void main(String[] args) {}

    public int majorityElement(int[] nums) {
        // The majority element count >= count of all other elements + 1
        int count = 0;
        int target = 0;
        for (int n : nums) {
            if (count == 0) {
                target = n; 
                count++;
            } else {
                if (target == n) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return target;
    }
}
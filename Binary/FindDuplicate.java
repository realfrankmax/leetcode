package Binary;

/**
 * @leetcode: 287. Find the Duplicate Number
 */
public class FindDuplicate {
    public static void main(String[] args) {}

    /**
     * A: Length from the beginning of list to the beginning of circle
     * B: Length that slow pointer moves in the circle when meeting fast pointer
     * C: Length from the meeting point to the beginning of circle in the same direction
     * B+C is the length of the circle
     * 
     * In first round:
     * Since slow pointer moves A+B, then fast pointer moves A+n*(B+C)+B
     * A+n*(B+C)+B == 2(A+B) which means A+B == n*len(circle)
     * 
     * In second round:
     * Slow and fast pointers both move A;
     * Slow starts from beginning of the list, fast starts from meeting point.
     * A == n*len(circle) - B == n*(B+C) - B == (n-1)*(B+C) + C
     * 
     * So they meet at the beginning of the circle
     */

    // Time O(n)
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length && nums[fast] < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return -1;
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    

    // Time O(nlogn)
    // Space: O(1)
    /**
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
    */

    // Time O(nlogn)
    // Binary search on counts of numbers in [1, n]
    /**
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    */
}
package Binary;

/**
 * @leetcode: 136. Single Number
 */
public class SingleNumber {
    public static void main(String[] args) {}

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res^n;
        }
        return res;
    }
}

package BinarySearch;

/**
 * @leetcode: 278. First Bad Version
 */
public class FirstBadVersion {
    public static void main(String[] args) {}

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
package BinarySearch;

import java.util.LinkedList;
import java.util.List;

/**
 * @leetcode: 658. Find K Closest Elements
 */
public class FindClosestElements {
    public static void main(String[] args) {}

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = findPos(arr, x);
        int i = pos-1;
        int j = pos;
        List<Integer> res = new LinkedList<>();
        while (res.size() != k) {
            if (i >= 0 && j < arr.length) {
                if (Math.abs(arr[i]-x) > Math.abs(arr[j]-x)) {
                    res.add(arr[j]);
                    j++;
                } else {
                    res.add(0, arr[i]);
                    i--;
                }
            } else if (i >= 0) {
                res.add(0, arr[i]);
                i--;
            } else {
                res.add(arr[j]);
                j++;
            }
        }
        return res;
    }

    // Binary search
    // Return position either equals to x or greater than x
    // If x is the largest, then return arr.length
    private int findPos(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}